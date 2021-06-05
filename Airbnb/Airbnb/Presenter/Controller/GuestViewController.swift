import UIKit
import RxSwift
import RxCocoa

final class GuestViewController: UIViewController {
    
    @IBOutlet weak var infantCountLabel: UILabel!
    @IBOutlet weak var kidCountLabel: UILabel!
    @IBOutlet weak var adultCountLabel: UILabel!
    
    @IBOutlet weak var guestLabel: UILabel!
    @IBOutlet weak var priceLabel: UILabel!
    @IBOutlet weak var dateLabel: UILabel!
    @IBOutlet weak var locationLabel: UILabel!
    
    @IBOutlet weak var nextButton: UIButton!
    @IBOutlet weak var skipDeleButton: UIButton!
    @IBOutlet weak var backButton: UIButton!
    @IBOutlet var buttonController: ButtonController!
    
    private let viewModel = GuestViewModel()
    private let guestManager = GuestManager()

    override func viewDidLoad() {
        super.viewDidLoad()
        setupMainView()
        bind()
    }
    
    func setupInfo(_ location:String, _ date:String, _ price:String) {
        viewModel.setupInfo(location, date, price)
    }
}

private extension GuestViewController {
    
    private func setupMainView() {
        setupBackButton()
        setupCountButtonController()
        setupNextButton()
        setupSkipDeleteButton()
    }
    
    private func setupBackButton() {
        backButton.rx.tap
            .subscribe(onNext: { [weak self] _ in
                self?.dismiss(animated: true, completion: nil)
            }).disposed(by: rx.disposeBag)
    }
    
    private func setupCountButtonController() {
        buttonController.setupButton()
        buttonController.bind { [weak self] (type, action) in
            switch action {
            case.increase: self?.guestManager.increase(type)
            case.decrease: self?.guestManager.decrease(type)
            }
        }
    }
    
    private func setupNextButton() {
        guestManager.nextPage
            .subscribe(onNext: { [weak self] touchable in
                switch touchable {
                case true:
                    self?.nextButton.isEnabled = true
                    self?.nextButton.setTitleColor(UIColor.black, for: .normal)
                    self?.skipDeleButton.setTitle("지우기", for: .normal)
                case false:
                    self?.nextButton.isEnabled = false
                    self?.nextButton.setTitleColor(UIColor.systemGray2, for: .normal)
                    self?.skipDeleButton.setTitle("건너뛰기", for: .normal)
                }
            }).disposed(by: rx.disposeBag)
    }
    
    private func setupSkipDeleteButton() {
        skipDeleButton.rx.tap
            .subscribe(onNext: { [weak self] _ in
                switch self?.guestManager.nextPage.value {
                case true:
                    self?.guestManager.removeAll()
                default:
                    break
                }
            }).disposed(by: rx.disposeBag)
    }
}

private extension GuestViewController {
    
    private func bind() {
        bindLocationLabel()
        bindDateLabel()
        bindPriceLabel()
        bindCountStateLabel()
    }
    
    private func bindLocationLabel() {
        viewModel.locationData
            .drive(locationLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
    
    private func bindDateLabel() {
        viewModel.dateData
            .drive(dateLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
    
    private func bindPriceLabel() {
        viewModel.priceData
            .drive(priceLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
    
    private func bindCountStateLabel() {
        guestManager.adultCount
            .drive(adultCountLabel.rx.text)
            .disposed(by: rx.disposeBag)
        
        guestManager.kidCount
            .drive(kidCountLabel.rx.text)
            .disposed(by: rx.disposeBag)
        
        guestManager.infantCount
            .drive(infantCountLabel.rx.text)
            .disposed(by: rx.disposeBag)
        
        guestManager.allGuestCount
            .drive(guestLabel.rx.text)
            .disposed(by: rx.disposeBag)
    }
}
