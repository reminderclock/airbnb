import UIKit

enum Action {
    case increase
    case decrease
}

final class ButtonMapper {
    private var map: [UIButton: GuestType]
    
    init(from buttons: [UIButton]) {
        self.map = Dictionary(uniqueKeysWithValues: zip(buttons, GuestType.allCases))
    }
    
    subscript(button: UIButton) -> GuestType? {
        return map[button]
    }
}

final class ButtonController:NSObject {
    
    @IBOutlet var decreaseButton:[UIButton]!
    @IBOutlet var increaseButton:[UIButton]!
    
    private var decreaseMapper: ButtonMapper?
    private var increaseMapper: ButtonMapper?
    
    private var buttonTouchedHandler: (GuestType, Action) ->()
    
    override init() {
        buttonTouchedHandler = { _, _ in }
    }
    
    func setupButton() {
        self.decreaseMapper = ButtonMapper(from: decreaseButton)
        self.increaseMapper = ButtonMapper(from: increaseButton)
    }
    
    
    @IBAction func decrease(sender: UIButton) {
        guard let guest = decreaseMapper?[sender] else { return }
        buttonTouchedHandler(guest, .decrease)
    }
    
    @IBAction func increase(sender: UIButton)  {
        guard let guest = increaseMapper?[sender] else { return }
        buttonTouchedHandler(guest, .increase)
    }
    
    func bind(action: @escaping (GuestType, Action) -> () ) {
        self.buttonTouchedHandler = action
    }
}
