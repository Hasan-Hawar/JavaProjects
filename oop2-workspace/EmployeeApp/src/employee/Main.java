package employee;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;

	@Override
	public void start(Stage primaryStage) throws IOException {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Employee App");
		showMainView();
		showMainItems();
	}

	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}

	public static void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scnene = new Scene(mainLayout, 800, 600);
		primaryStage.setScene(scnene);
		primaryStage.show();
	}

	public static void showEleciricalScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("electrical/ElectricalDep.fxml"));
		BorderPane electricalDep = loader.load();
		mainLayout.setCenter(electricalDep);

	}

	public static void showMechanicalScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("mechanical/MechanicalDep.fxml"));
		BorderPane mechanicalDep = loader.load();
		mainLayout.setCenter(mechanicalDep);
	}

	public static void showAddStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewEmployee.fxml"));
		BorderPane addNewEmployee = loader.load();

		Stage addDialogeStage = new Stage();
		addDialogeStage.setTitle("Add New Employee");
		addDialogeStage.initModality(Modality.WINDOW_MODAL);
		addDialogeStage.initOwner(primaryStage);
		Scene scene = new Scene(addNewEmployee);
		addDialogeStage.setScene(scene);
		addDialogeStage.showAndWait();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
