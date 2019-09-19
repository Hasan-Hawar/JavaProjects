package Banksystem.view.EBanking;

import Banksystem.Bank;
import Banksystem.IEBanking;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * this class contain what belong to scene and panes
 *
 */
public class MainEBanking extends Application {
	private HBox mainPane;
	private Pane[] panes;
	private Button button1;
	private Button button2;
	private ControllerEBanking controller;
	private Bank admin;
	private Stage stage;
	private IEBanking iebanking;
	private Stage primaryStage;

	
	@Override
	public void init() throws Exception {
	
		controller = new ControllerEBanking(iebanking);
		controller.setMain(this);
					panes = new Pane[controller.getNumberOfScreens()];
					panes[0] = new LoginScreen(controller);
					panes[1] = new OverviewScreen(controller);
					panes[2] = new TableScreen(controller);
					panes[3] = new TransferScreen(controller);
	}

	@Override
	public void start(Stage stage) {
	
		stage.setWidth(750);
		stage.setHeight(530);

		BorderPane root = new BorderPane();
		mainPane = new HBox();
		mainPane.setMaxWidth(750);
		mainPane.getChildren().add(panes[controller.nr]);

		root.setCenter(mainPane);

		Scene scene = new Scene(root);
		scene.getStylesheets().add("Banksystem/res/style.css");
		stage.setScene(scene);
		stage.setOnCloseRequest(e->{ 
			Platform.exit(); 
			System.exit(0);
		});
	
		stage.show();
	}

	public static void main (String[] args) {
		launch(args);
	}

	
	/**
	 * clear actual screen from mainPane
	 */
	public void clearScreen() {
		mainPane.getChildren().clear();
	}

	/**
	 * add screen with number nr to mainPane
	 */
	public void addScreen(int nr) {
		nr=controller.getNr();
		mainPane.getChildren().add(panes[nr]);
	}
	
	public Pane[] getPanes() {
		return panes;
	}
	
}
