package pt.iade.shoplist;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.iade.shoplist.controllers.MainController;
import pt.iade.shoplist.controllers.ShopListController;
import pt.iade.shoplist.models.Shoplist;

final public class WindowManager {

	static private Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		WindowManager.primaryStage = primaryStage;
	}

	private WindowManager() {}


	static public void openItemsWindow(Shoplist shoplist) {
		Parent root = createNodeTree("./views/ShopListView.fxml",
				new ShopListController(shoplist));		
		// Replace the content of the current window (primaryStage)
		primaryStage.getScene().setRoot(root);
		/*
		// Open in a new window
		Stage stage = new Stage();
		
		// Opens a modal window that blocks the owner
		//stage.initOwner(primaryStage);
		//stage.initModality(Modality.WINDOW_MODAL);
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				Main.class.getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
		*/
	}
	
	// When we go back to main window
	static public void backToMainWindow() {
		Parent root = createNodeTree("./views/MainView.fxml",
				new MainController());			
		primaryStage.getScene().setRoot(root);	
	}

	
	// When we first open the window
	static public void openMainWindow() {
		Parent root = createNodeTree("./views/MainView.fxml",
				new MainController());			
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				Main.class.getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	static public Parent createNodeTree(String viewPath, Object controller) {
		try {
			FXMLLoader loader = new FXMLLoader(
					Main.class.getResource(viewPath));
			loader.setController(controller);
			Parent root = loader.load();
			return root;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
