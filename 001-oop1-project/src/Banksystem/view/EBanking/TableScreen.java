package Banksystem.view.EBanking;
import java.util.ArrayList;
import java.util.Arrays;

import Banksystem.BankAccount;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;


public class TableScreen extends VBox {
	TableView<BankAccount> table;
	private ControllerEBanking controller;
	private String[] transfers; 

	/**
	 * Contain the scene and panes of Tablescreen of EBanking
	 *
	 */
public TableScreen(ControllerEBanking controller) {
	this.controller=controller;
	this.setId("TableScreen");

	transfers = controller.getTransfers(controller.getSelectedBankAccount());

	new ArrayList<>(Arrays.asList(transfers));
	
	VBox vbox = new VBox(10.0);
	vbox.setMinHeight(100);
	vbox.setMaxHeight(250);
	        Label lTransfers = new Label("Transfers: ");
	        final ListView<String> transferList = new ListView<>();
	        transferList.getItems().addAll(transfers);
	       
	        HBox hbox=new HBox();
	        Button bAbbrechen = new Button("Abbrechen");
	        bAbbrechen.setOnAction(event -> {
	        	System.exit(0);
			});	        

	        hbox.getChildren().addAll(bAbbrechen);
	    	vbox.getChildren().addAll(lTransfers,transferList,hbox);
	    	getChildren().addAll(vbox);
	    	vbox.setAlignment(Pos.CENTER);
}
}
	    	

