package ch.csbe.hello;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModulApp extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("modulerfassung.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("modul.css").toExternalForm());
		primaryStage.setTitle("Modul erfassen");
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
