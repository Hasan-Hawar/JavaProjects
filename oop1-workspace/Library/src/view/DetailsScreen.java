package view;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import library.data.Item;


public class DetailsScreen extends VBox {
	public DetailsScreen() {
		this.setId("detailsScreen");

		// Pane durch sinnvollen Container ersetzen und mit Inhalt füllen.
		// . . .
		Label l1 = new Label("To be found ...");
		
		ImageView image = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/libImg.jpg")));
		image.setFitWidth(550);
		image.setFitHeight(400);
		image.setPreserveRatio(false);
		image.setX(120);
		image.setY(100);
		image.setPreserveRatio(false);
		
		//l1.setBorder(getBorder());
		setAlignment(Pos.CENTER);
		
		getChildren().addAll(image, l1);
	}

	public void setContent(Item selectedItem) {
		// TODO Auto-generated method stub
		
	}
}
