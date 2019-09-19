package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;

public final class AddActionHandler implements EventHandler<ActionEvent> {
	private ObservableList<Person> persons;

	public AddActionHandler(ObservableList<Person> persons) {
		this.persons = persons;
	}

	@Override
	public void handle(ActionEvent arg0) {
		Stage addDialog = new Stage();
		addDialog.setTitle("Add person");
		addDialog.getIcons().add(new Image("/icon.jpg"));
		addDialog.initModality(Modality.APPLICATION_MODAL);
		
		Scene addPersonScene = AddPersonSceneBuilder.createScene(persons);
		addDialog.setScene(addPersonScene);
		
		addDialog.showAndWait();
	}

}
