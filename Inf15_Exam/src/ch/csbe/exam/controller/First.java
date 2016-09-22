package ch.csbe.exam.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class First extends Controller{
	
	@FXML protected TextField input;

	protected void next(){
		Second s = new Second();
		new Navigator().navigate(s);
		s.setText(input.getText());
	}
	
}
