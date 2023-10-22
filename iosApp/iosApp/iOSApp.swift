import SwiftUI
import FirebaseCore
import shared

@main
struct iOSApp: App {
    
    init(){
        FirebaseApp.configure()
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
