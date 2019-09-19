package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import persistence.PersonDAO;
import persistence.TextFile.SerialisationFilePerson;

public class Main extends Application {
	private PersonDAO dao = new SerialisationFilePerson("person.txt");
	private ObservableList<Person> persons;

	@Override
	public void start(Stage primaryStage) {

		Scene scene = PersonRegistryDataList.creatScene(persons);
		primaryStage.setTitle("Person Registry");
		primaryStage.getIcons().add(new Image("/index.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		persons = FXCollections.observableArrayList(dao.loadPerson());
	}

	@Override
	public void stop() {
		dao.saveperson(new ArrayList<Person>(persons));
	}

}
