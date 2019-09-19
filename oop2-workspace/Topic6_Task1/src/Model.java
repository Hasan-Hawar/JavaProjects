import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Model extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
		Pane pane = loader.load();
		primaryStage.setTitle("COUNTER A & B");
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
