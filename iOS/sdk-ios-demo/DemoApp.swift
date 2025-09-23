//
//  DemoApp.swift
//  sdk-ios-demo
//
//  Created by Oleksandr Kryvodub on 23.9.2025.
//

import SwiftUI
import ChoicelyCore

@main
struct DemoApp: App {
    
    init() {
        
        ChoicelySDK.settings.externalViewControllerFactory = YourCustomViewControllerFactory()
        ChoicelySDK.initialize(
            application: UIApplication.shared,
            appKey: "Y2hvaWNlbHktZXUvYXBwcy9kS1lHUUtUbWREa1pRb1ltZFRiZQ"
        )
    }
    
    var body: some Scene {
        WindowGroup {
            ChoicelySplashView()
        }
    }
}
