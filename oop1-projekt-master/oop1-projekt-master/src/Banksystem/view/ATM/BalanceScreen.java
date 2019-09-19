package Banksystem.view.ATM;

import Banksystem.BankAccount;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * Contain the scene and panes of balanceScreen of ATM
 *
 */
public class BalanceScreen extends VBox {
	protected static Label GetKontoState;
	private ControllerATM controller;

	public BalanceScreen(ControllerATM controller) {
		this.controller = controller;
		this.setId("BalanceScreen");
		GridPane pane = new GridPane();

		Label lKontoState = new Label("Kontostand ");
		Label getKontoState = new Label();
		getKontoState.setText(controller.getBalance(controller.getAccount()));

		Button bPayOff = new Button("Geld abziehen");
		bPayOff.setOnAction(event -> {
			controller.nextScreen();
		});
		Button bCancel = new Button("cancel");
		bCancel.setOnAction(event -> {
			System.exit(0);
		});

		pane.add(lKontoState, 0, 0);
		pane.add(getKontoState, 1, 0, 2, 1);
		HBox butonAll = new HBox();
		butonAll.getChildren().addAll(bCancel, bPayOff);
		pane.add(butonAll, 1, 2);

		getChildren().addAll(pane);

	}

}
