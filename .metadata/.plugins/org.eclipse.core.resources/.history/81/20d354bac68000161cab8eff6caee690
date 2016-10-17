package ch.csbe.exam.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Second extends Controller{

	@FXML protected TextField input;
	
	public void setText(String value){
		input.setText(value);
	}
	
	protected void next(){
		new Navigator().navigate(new First());
	}
}
