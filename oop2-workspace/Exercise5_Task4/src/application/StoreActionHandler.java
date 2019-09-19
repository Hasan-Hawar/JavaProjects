package application;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Person;
import persistence.PersistenceException;
import persistence.jaxb.PersonDaoJAXB;

public final class StoreActionHandler implements EventHandler<ActionEvent> {
	private ObservableList<Person> persons;
	private Scene scene;

	public StoreActionHandler(ObservableList<Person> persons, Scene scene) {
		this.persons = persons;
		this.scene = scene;
	}

	@Override
	public void handle(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Store Person Data");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("XML files", "*.xml"));
		File selectedFile = fileChooser.showSaveDialog(scene.getWindow());
		if (selectedFile != null) {
			try {
				PersonDaoJAXB dao = new PersonDaoJAXB(selectedFile);
				dao.save(persons);
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Alert alert = AlertBuilder.createErrorAlert("Store error", "Cannot store to file", e.getMessage());
				alert.showAndWait();
			}
		}
	}
}
