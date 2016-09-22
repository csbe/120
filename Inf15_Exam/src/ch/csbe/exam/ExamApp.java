package ch.csbe.exam;

import ch.csbe.exam.controller.First;
import ch.csbe.exam.controller.Navigator;
import javafx.application.Application;
import javafx.stage.Stage;

public class ExamApp extends Application {
	
	public static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ExamApp.stage = stage;
		new Navigator().navigate(new First());
		
		stage.setTitle("Exam");
		stage.show();
	}

}
