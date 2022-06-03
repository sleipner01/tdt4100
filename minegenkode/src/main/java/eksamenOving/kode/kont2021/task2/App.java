package eksamenOving.kode.kont2021.task2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Voteshit");
		primaryStage.setScene(new Scene(FXMLLoader.load(App.class.getResource("UI.fxml"))));
		primaryStage.show();
	}

	public static void main(String[] args) {
		App.launch(args);
	}

}
