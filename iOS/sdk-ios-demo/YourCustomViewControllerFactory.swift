//
//  YourCustomViewControllerFactory.swift
//  sdk-ios-demo
//
//  Created by Oleksandr Kryvodub on 23.9.2025.
//

import Foundation
import ChoicelyCore

class YourCustomViewControllerFactory: ChoicelyExternalViewControllerFactory {
    
    func createViewController(choicelyNavigationitem: ChoicelyNavigationItem?) -> ChoicelyController? {
        let yourCustomUrl = "choicely://custom-screen"
        let internalUrl = choicelyNavigationitem?.internalUrl
        
        if internalUrl?.contains(yourCustomUrl) == true {
            return ChoicelyView { YourCustomView() }
        }
        
        return nil
    }
}
