package eksamenOving.kode.kont2020.stuff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MathController {
	
	Random rand;

	@FXML
	private ComboBox<Character> typeSelector;

	@FXML
	private TextField firstField;

	@FXML
	private TextField secondField;
	
	@FXML
	private TextArea resultArea;

	@FXML
	private void initialize() {
		rand = new Random();
		Collection<Character> tmp = new ArrayList<>();
		tmp.add('+');
		tmp.add('*');
		tmp.add('/');
		tmp.add('-');
		typeSelector.getItems().addAll(tmp);
		typeSelector.getSelectionModel().select(0);
	}


	/**
	 * Gather doubles from two textfields, apply a mathematical method, and update a text component.
	 */
	@FXML
	private void onCalculate() {
		Float firstNumber = Float.parseFloat(firstField.getText());
		// if(firstNumber == null) throw new IllegalArgumentException("Not a number");
		Float secondNumber = Float.parseFloat(secondField.getText());
		// if(secondNumber == null) throw new IllegalArgumentException("Not a number");

		Character operator = typeSelector.getValue();

		Float value = null;

		switch (operator) {
			case '+':
				value = firstNumber + secondNumber;
				break;
			case '-':
				value = firstNumber - secondNumber;
				break;			
			case '*':
				value = firstNumber * secondNumber;
				break;
			case '/':
				value = firstNumber / secondNumber;
				break;
		}


		resultArea.setText(Float.toString(value));
	}

	
	// Is there a method missing here? Where could it be?
	@FXML
	private void randomizeNumbers() {
		firstField.setText(Float.toString(rand.nextFloat(1, 100)));
		secondField.setText(Float.toString(rand.nextFloat(1, 100)));
		onCalculate();
	}
}
