package eksamenOving.kode.kont2020.stuff;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MathApp extends Application {

	@Override
	public void start(final Stage stage) throws Exception {
		final Parent root = FXMLLoader.load(getClass().getResource("Math.fxml"));
		stage.setScene(new Scene(root));
		stage.show();
	}

	public static void main(final String[] args) {
		Application.launch(args);
	}
}
