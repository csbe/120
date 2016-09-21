package ch.csbe.rechner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class CalcController {

	@FXML protected Label output;
	@FXML protected Label calc;
	private String result = "";
	private String outputtext = "";
	private boolean positive = true;
	
	@FXML protected void calc(MouseEvent event) throws ScriptException{
		Label l = (Label) event.getSource();
		
		switch(l.getText()){
		case "C": calc.setText("");
		case "CE": 
				output.setText(""); 
				result=""; 
				outputtext=""; 
				initialize(); 
				break;
		case "=": 
			try{
				result += outputtext + ";";
				ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
				outputtext = engine.eval(result).toString();
				calc.setText(""); 
				output.setText(outputtext); 
			}catch(Exception e){
				output.setText("Ungültig!");
				outputtext = "";
			}
			result=""; 
			break;
		case "±": 
			String sign = (positive)?"-":"+";
			outputtext =  sign + outputtext;
			positive = !positive;
			output.setText(outputtext);	
			break; 
		case "<": 
			outputtext = outputtext.substring(0,outputtext.length()-1); 
			output.setText(outputtext); 
			break; 
		case ":": ; 
		case "*": ; 
		case "-": ; 
		case "+": 
			positive = true;
			result += outputtext + " " + l.getText() + " ";
			outputtext = "";
			calc.setText(result);			
			break;
		default: 
			outputtext += l.getText();
			output.setText(outputtext);
			break;
		}
		
		
	}
	
	@FXML protected void initialize(){
		if(outputtext.length() == 0){
			output.setText("0");
		}
	}
	
}
