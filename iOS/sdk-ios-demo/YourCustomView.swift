//
//  YourCustomView.swift
//  sdk-ios-demo
//
//  Created by Oleksandr Kryvodub on 23.9.2025.
//

import SwiftUI

struct YourCustomView: View {
    var body: some View {
        VStack {
            Image(systemName: "star.fill")
                .imageScale(.large)
                .foregroundStyle(.yellow)
            Text("This is a custom view!")
                .font(.headline)
                .padding()
        }
        .padding()
        .background(Color.blue.opacity(0.1))
        .cornerRadius(10)
        .shadow(radius: 5)
    }
}

#Preview {
    YourCustomView()
}
