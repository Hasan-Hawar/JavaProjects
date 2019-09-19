package Banksystem.view.ATM;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * Contain the scene and panes of WithdrawScreen of ATM
 *
 */
public class WithdrawScreen extends VBox {
	private ControllerATM controller;
	private LoginScreen loginScreen;

	public WithdrawScreen(ControllerATM controller) throws RemoteException, NullPointerException {
		this.setId("WithdrawScreen");
		this.controller = controller;
		GridPane pane = new GridPane();

		Label lAmount = new Label("Betrag");
		TextField txtAmount = new TextField();

		Button bPayOff = new Button("Geld abziehen");
		bPayOff.setOnAction(event -> {
			controller.payoffMoney(loginScreen.getTxtAccountNumber(), txtAmount.getText());
			System.exit(0);

		});
		Button bCancel = new Button("Abbrechen");
		bCancel.setOnAction(event -> {
			System.exit(0);
		});

		pane.add(lAmount, 0, 0);
		pane.add(txtAmount, 1, 0, 2, 1);
		HBox butonAll = new HBox();
		butonAll.getChildren().addAll(bCancel, bPayOff);
		pane.add(butonAll, 1, 2);

		getChildren().addAll(pane);

	}
}
