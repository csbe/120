package ch.csbe.hello;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerModulErfassung {
	
	@FXML protected TextField nr;
	@FXML protected Button abort;
	
	@FXML protected void initialize(){
		abort.getStyleClass().add("abort");
	}
	
	@FXML protected void save(ActionEvent event){
		String s = nr.getText();
		try{
			int i = Integer.parseInt(s);
			nr.getStyleClass().remove("error");
			System.out.println(i);
		}catch(NumberFormatException e){
			nr.getStyleClass().add("error");
			nr.setStyle("-fx-focus-color: transparent;");
			nr.setText("");
			nr.requestFocus();
		}
	}
	
	@FXML protected void abort(ActionEvent event){
		System.out.println("Abort");
	}

}
