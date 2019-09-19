package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public final class CancelActionHandler implements EventHandler<ActionEvent> {
	private Pane pane;

	public CancelActionHandler(Pane pane) {
		this.pane = pane;
	}

	@Override
	public void handle(ActionEvent event) {
		pane.getScene().getWindow().hide();
	}
}
