package view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class TableScreen extends Pane {
	public TableScreen() {
		this.setId("tableScreen");
		
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
	     
		
		Label lb1 = new Label("Buch1 | Titel1 | Schriftsteller1 | 100");
		lb1.setMinSize(400, 10);
		Label lb2 = new Label("Buch2 | Title2 | Schriftsteller2 | 200"); 
		lb2.setMinSize(400, 10);
		Label lb3 = new Label("Buch3 | Title3 | Schriftsteller3 | 300"); 
		lb3.setMinSize(400, 10);
		Label lb4 = new Label("Buch4 | Title4 | Schriftsteller4 | 400"); 
		lb4.setMinSize(400, 10);
		Label lb5 = new Label("Journal | Title5 | Publisher1 | 85");
		lb5.setMinSize(400, 10);
		Label lb6 = new Label("Film10 | Title11 | Schauspieler11 | 110"); 
		lb6.setMinSize(400, 10);
		Label lb7 = new Label("Film20 | Title12 | Schauspieler12 | 120"); 
		lb7.setMinSize(400, 10);
		
		
		
		CheckBox box1 = new CheckBox();
		CheckBox box2 = new CheckBox();
		CheckBox box3 = new CheckBox();
		CheckBox box4 = new CheckBox();
		box4.setSelected(true);
		CheckBox box5 = new CheckBox();
		box5.setSelected(true);
		CheckBox box6 = new CheckBox();
		CheckBox box7 = new CheckBox();
		
		grid.add(lb1, 0, 1); grid.add(box1,1,1);
		grid.add(lb2, 0, 2); grid.add(box2,1,2);
		grid.add(lb3, 0, 3); grid.add(box3,1,3);
		grid.add(lb4, 0, 4); grid.add(box4,1,4);
		grid.add(lb5, 0, 5); grid.add(box5,1,5);
		grid.add(lb6, 0, 6); grid.add(box6,1,6);
		grid.add(lb7, 0, 7); grid.add(box7,1,7);
		
		getChildren().addAll(image,grid);
				
		
	}

	public TableView getTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
