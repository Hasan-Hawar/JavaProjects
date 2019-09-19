package Banksystem.view.EBanking;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 * Contain the scene and panes of transferScreen of EBanking
 *
 */
public class TransferScreen extends VBox {

	private ControllerEBanking controller;

	public TransferScreen(ControllerEBanking controller)  {
		this.controller = controller;
		this.setId("TransferScreen");

		GridPane pane = new GridPane();

		Label lAccountTo = new Label("Ziel-Konto");
		Label lAmount = new Label("Betrag");

		TextField txtAccountTo = new TextField();
		TextField txtAmount = new TextField();

		Button bTransfer = new Button("Überweisen");
		bTransfer.setOnAction(event -> {
	if (txtAccountTo.getText() != null && txtAmount.getText() != null) {

		controller.transferMoney(controller.getSelectedBankAccount(), txtAccountTo.getText(), txtAmount.getText());
		System.exit(0);}
		
			
		});

		pane.add(lAccountTo, 0, 0);
		pane.add(txtAccountTo, 1, 0, 2, 1);
		pane.add(lAmount, 0, 1);
		pane.add(txtAmount, 1, 1, 2, 1);
		pane.add(bTransfer, 1, 2);

		getChildren().addAll(pane);

	}
}
