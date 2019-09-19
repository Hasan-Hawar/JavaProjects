import java.math.BigInteger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Model extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		BorderPane root = new BorderPane();
		FXMLLoader loader = new FXMLLoader();

		loader.setLocation(getClass().getResource("Factorial.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	public static BigInteger factorialer(BigInteger num) {
		BigInteger result = BigInteger.valueOf(1);

		for (long factor = 2; factor <= num.longValue(); factor++) {
			result = result.multiply(BigInteger.valueOf(factor));
		}
		return result;
	}

}
