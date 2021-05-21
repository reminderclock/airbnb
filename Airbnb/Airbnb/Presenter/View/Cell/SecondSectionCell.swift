import UIKit
import RxSwift

class SecondSectionCell: UICollectionViewCell {
    
    static let identifier = "SecondSectionCell"
    
    private lazy var horizontalCollectionView: UICollectionView = {
        let layout = UICollectionViewFlowLayout()
        layout.scrollDirection = .horizontal
        let collectionView = UICollectionView(frame: CGRect(x: 0, y: 0, width: frame.width, height: frame.height), collectionViewLayout: layout)
        collectionView.backgroundColor = UIColor.clear
        collectionView.register(RegieonInfoCell.self, forCellWithReuseIdentifier: RegieonInfoCell.identifier)
        collectionView.delegate = self
        return collectionView
    }()
    
    private let viewModel = MainViewModel()
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupMainCellView()
        bind()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupMainCellView()
        bind()
    }
}

private extension SecondSectionCell {
    
    private func setupMainCellView() {
        addSubview(horizontalCollectionView)
        backgroundColor = UIColor.clear
    }
    
    private func bind() {
        viewModel.secondViewList()
            .bind(to: horizontalCollectionView.rx.items(cellIdentifier: RegieonInfoCell.identifier, cellType: RegieonInfoCell.self)) { row, data, cell in
                cell.configure(data)
            }.disposed(by: rx.disposeBag)
    }
}

extension SecondSectionCell: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        let (width, height) = (frame.width*0.5, frame.height*0.4)
        return CGSize(width: width, height: height)
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return UIEdgeInsets(top: 0, left: 10, bottom: 0, right: 10)
    }
}
