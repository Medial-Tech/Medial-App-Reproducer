import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {

   func makeUIViewController(context: Context) -> UIViewController {
       let viewController = MainAppKt.MainViewController()
       KoinConfig(uiController: viewController).doInitKoin()
       return viewController
   }

   func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {

    @State private var openedUrl: String?
    
    var body: some View {
        ComposeView()
    }
    
}


struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
