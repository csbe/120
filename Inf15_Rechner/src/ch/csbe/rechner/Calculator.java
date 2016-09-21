package ch.csbe.rechner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Calculator extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent p = FXMLLoader.load(getClass().getResource("calculator.fxml"));
		Scene scene = new Scene(p);
		
		stage.setTitle("Rechner");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	}

}
