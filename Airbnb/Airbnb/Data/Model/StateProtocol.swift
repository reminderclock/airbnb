import Foundation
import RxSwift
import RxCocoa

protocol StateProtocol {
    
    func countStates() -> Observable<Int>
    func increase()
    func decrease()
    func remove()
}

final class AdultState: StateProtocol {
    
    private var count = 0
    private lazy var countState = BehaviorSubject(value: count)
    
    func countStates() -> Observable<Int> {
        return countState
    }
    
    func increase() {
        count += 1
        countState.onNext(count)
    }
    
    func decrease() {
        count -= 1
        countState.onNext(count)
    }
    
    func remove() {
        count = 0
        countState.onNext(count)
    }
}

final class KidState: StateProtocol {
    
    private var count = 0
    private lazy var countState = BehaviorSubject(value: count)
    
    func countStates() -> Observable<Int> {
        return countState
    }
    
    func increase() {
        count += 1
        countState.onNext(count)
    }
    
    func decrease() {
        count -= 1
        countState.onNext(count)
    }
    
    func remove() {
        count = 0
        countState.onNext(count)
    }
}

final class InfantState: StateProtocol {
    private var count = 0
    private lazy var countState = BehaviorSubject(value: count)
    
    func countStates() -> Observable<Int> {
        return countState
    }
    
    func increase() {
        count += 1
        countState.onNext(count)
    }
    
    func decrease() {
        count -= 1
        countState.onNext(count)
    }
    
    func remove() {
        count = 0
        countState.onNext(count)
    }
}
