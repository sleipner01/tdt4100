package uke5.downcounter;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DownCounterController {

	DownCounter downCounter = new DownCounter(3);
	
	@FXML TextField input;
	@FXML Text output;

	@FXML
	void handleNew() {
		int i = Integer.valueOf(input.getText());
		downCounter = new DownCounter(i);
		output.setText("Starter med "+i+": ");
//		updateOutput();
	}

	void updateOutput() {
		String outputString = "Ferdig? ";
		if (downCounter.isFinished()) {
			outputString += " Ja!";
		} else {
			outputString += " Nei";			
		}
		output.setText(outputString);
	}
	
	@FXML
	void handleCountDown() {
		downCounter.countDown();
		updateOutput();
	}
}
