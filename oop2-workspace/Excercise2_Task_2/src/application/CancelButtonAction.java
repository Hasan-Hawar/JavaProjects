package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class CancelButtonAction implements EventHandler<ActionEvent> {

	private Pane pane;

	public CancelButtonAction(Pane pane) {
		this.pane = pane;
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

		pane.getScene().getWindow().hide();

	}

}
