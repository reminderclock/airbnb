import UIKit

class ThirdSectionCell: UICollectionViewCell {
    
    static let identifier = "ThirdCell"
    
    private lazy var thirdSectionView: ThirdSectionView = {
        let thirdView = ThirdSectionView(frame: CGRect(x: 0, y: 0, width: frame.width, height: frame.height*0.8))
        return thirdView
    }()
        
    override init(frame: CGRect) {
        super.init(frame: frame)
        setupMainCell()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupMainCell()
    }
    
    func configure(_ item:MainViewInfo) {
        thirdSectionView.configure(item)
    }
}

extension ThirdSectionCell {
    private func setupMainCell() {
        addSubview(thirdSectionView)
    }
}
