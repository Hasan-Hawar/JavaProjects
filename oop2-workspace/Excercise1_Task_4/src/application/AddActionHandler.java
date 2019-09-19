package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddActionHandler implements EventHandler<ActionEvent> {
	private ObservableList<Person> persons;

	public AddActionHandler(ObservableList<Person> persons) {
		this.persons = persons;
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Stage addScreen = new Stage();
		addScreen.setTitle("Add Person");
		addScreen.getIcons().add(new Image("/icon.jpg"));
		addScreen.initModality(Modality.APPLICATION_MODAL);

		Scene addPerosn = AddPersonSceneBiulder.creatScene(persons);
		addScreen.setScene(addPerosn);
		addScreen.showAndWait();

	}

}
