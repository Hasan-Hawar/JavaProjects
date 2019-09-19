package view;




import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class SearchScreen extends Pane {
	private Controller controller;
	ObservableList<String> category;
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
	     
		final ToggleGroup radioGroup = new ToggleGroup();
		radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			 public void changed(ObservableValue<? extends Toggle> ov, Toggle toggle, Toggle new_toggle) {
					if (new_toggle != null)
					    System.out.println(radioGroup.getSelectedToggle().getUserData());
		}
		});
		
		ChoiceBox<String> libraryKat = new ChoiceBox<String>();
		libraryKat.getItems().addAll(
				"Book",
		        "Music",
		        "Film",
		        "Journal");
		
		libraryKat.setValue("Select a Category");
		
		Label lb = new Label("Category");	    
	    Label lb1 = new Label("Title/Key Word");
		Label lb3 = new Label("Actor");
		lb3.setMinSize(170, 10);
		
		TextField t1 = new TextField();
		t1.setAlignment(Pos.CENTER_RIGHT);
		t1.textProperty().bindBidirectional(controller.getTitle());
		
		TextField t2 = new TextField();
		t2.textProperty().bindBidirectional(controller.getWriterFirstName());
		t2.textProperty().bindBidirectional(controller.getActorFirstName());
		
		TextField t3 = new TextField();
		t3.textProperty().bindBidirectional(controller.getActorLastName());
		t3.textProperty().bindBidirectional(controller.getActorLastName());
		
		
		
		RadioButton button1 = new RadioButton("Nur Verfügbare");
		RadioButton button2 = new RadioButton("Alle");
		button1.setToggleGroup(radioGroup);
		button2.setToggleGroup(radioGroup);
		button1.setSelected(true);;
	
		
		
		//grid.add(image, 0, 0);
		
		
		
	
		libraryKat.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(libraryKat.getItems().get((Integer)newValue));
				switch (libraryKat.getItems().get((Integer)newValue)){
					case "Book" :
						grid.getChildren().setAll(new TextField());
						break;
					case "Film" :
						grid.getChildren().setAll(new TextField());
						break;
					case "Journal" :
						grid.getChildren().setAll(new TextField());
						break;
					case "Music" :
						grid.getChildren().setAll(new TextField());
						break;	
				}
			}
		});
		grid.add(lb, 0, 1); grid.add(libraryKat, 1, 1);
		grid.add(lb1, 0, 2);  grid.add(t1, 1, 2);
		grid.add(lb3, 0, 3); grid.add(t2, 1, 3); grid.add(t3, 2, 3);
		grid.add(button1, 1, 4); grid.add(button2, 2, 4);
				getChildren().addAll(image,grid);
	}
	

}
