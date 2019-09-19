package view;




import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class SearchScreen extends Pane {

	public SearchScreen() {
		this.setId("searchScreen");

		// Pane durch sinnvollen Container ersetzen und mit Inhalt füllen.
		// . . .
		ImageView image = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));
		image.setFitWidth(270);
		image.setFitHeight(120);
		image.setPreserveRatio(false);
		image.setX(420);
		image.setY(80);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(220, 15, 15, 90));
		grid.setVgap(5);
		grid.setHgap(5);

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(15);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(25);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(50);
		grid.getColumnConstraints().addAll(col1,col2,col3);
	     
	
		
		ComboBox<String> libraryKat = new ComboBox<String>();
			      
		libraryKat.getItems().addAll(
				"Book",
		        "Music",
		        "Film",
		        "Journal");
		
		libraryKat.setValue("Select a Category");
			    
		/*  ObservableList<String> list = FXCollections.observableArrayList(); 
	    list.addAll("Book", "Film","Music", "Journal");
	    ListView<String> listView = new ListView<String>(FXCollections.observableArrayList());
       listView.setPrefSize(200, 250);
       listView.setEditable(true);
	   for (int i = 0; i < 18; i++) {
           FXCollections.observableArrayList().add("anonym");
       }
         
       listView.setItems(FXCollections.observableArrayList());
       listView.setCellFactory(ComboBoxListCell.forListView(list));  
	   */
	    Label lb1 = new Label("Title");
		Label lb2 = new Label("Verlag");
		Label lb3 = new Label("Schriftsteller/in");
		Label lb4 = new Label("Schauspieler'in");
		lb4.setMinSize(170, 10);
		Label lb5 = new Label("kategorien");
		
		TextField tF1 = new TextField();
	
		tF1.setAlignment(Pos.CENTER_RIGHT);
		TextField tF2 = new TextField();
		
		TextField tF3 = new TextField();
	
		TextField tF4 = new TextField();

		tF4.setAlignment(Pos.CENTER_RIGHT);
		
		ToggleGroup radioGroup = new ToggleGroup();
		RadioButton button1 = new RadioButton("Nur Verfügbare");
		RadioButton button2 = new RadioButton("Alle");
		button1.setToggleGroup(radioGroup);
		button2.setToggleGroup(radioGroup);
		button1.setSelected(true);;
	
		
		
		grid.add(image, 0, 0);
		grid.add(lb5, 0, 1); grid.add(libraryKat, 1, 1);
		grid.add(lb1, 0, 2);  grid.add(tF1, 1, 2);
		grid.add(lb2, 0, 3); grid.add(tF2, 1, 3);
		grid.add(lb3, 0, 4);    grid.add(tF3, 1, 4);
		grid.add(lb4, 0, 5); grid.add(tF4, 1, 5);
		grid.add(button1, 1, 6); grid.add(button2, 2, 6);
		
		getChildren().addAll(image,grid);
	}

}
