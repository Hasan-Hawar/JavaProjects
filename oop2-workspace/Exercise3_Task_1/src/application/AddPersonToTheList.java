package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddPersonToTheList implements EventHandler<ActionEvent> {

	private ObservableList<Person> persons;

	public AddPersonToTheList(ObservableList<Person> persons) {
		this.persons = persons;
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

		Stage stage = new Stage();
		stage.setTitle("Add Person");
		stage.getIcons().add(new Image("/index.jpg"));
		stage.initModality(Modality.APPLICATION_MODAL);

		Scene addPersonscene = PersonRegistryData.creatScene(persons);
		stage.setScene(addPersonscene);

		stage.showAndWait();

	}

}
