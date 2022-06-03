package eksamenOving.kode.kont2021.task2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {

	// TODO - Add any needed fields here
	@FXML
	public TextArea output;
	@FXML
	private TextField username, password;
	public static String logInSuccess = "Gratulerer du har logget inn!";
	public static String logInFailed = "Feil brukernavn eller passord";



	
	//TODO - what should be the name of this method? Uncomment this part of the
	// code and put it inside the correct function
	public void onLogIn() { 
		String brukernavn = username.getText();
	 	String passord = password.getText();
	
	 	if(brukernavn.equals("admin") && passord.equals("admin")) 
	 		output.setText(logInSuccess);
		else output.setText(logInFailed);  
	}
	 

}
