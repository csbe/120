package ch.csbe.exam.controller;

import java.io.IOException;

import ch.csbe.exam.ExamApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Navigator {
	
	public void navigate(Controller c){
		String next = c.getClass().getSimpleName().toLowerCase();
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/"+next+".fxml"));
		Controller f = loader.<Controller>getController();
		Parent p;
		try {
			p = loader.load();
			Scene s = new Scene(p);
			ExamApp.stage.setScene(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
