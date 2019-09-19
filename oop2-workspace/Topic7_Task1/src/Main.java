
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ResourceBundle resources = ResourceBundle.getBundle("example", Locale.GERMANY);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"), resources);

		Parent root = loader.load();
		Scene scene = new Scene(root);

		primaryStage.setTitle("I18n Example");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
