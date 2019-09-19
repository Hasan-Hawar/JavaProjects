package Banksystem.view.EBanking;

import java.util.ArrayList;
import java.util.Arrays;
import Banksystem.BankAccount;
import Banksystem.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



/**
 * Contain the scene and panes of OverviewScreen of EBanking
 *
 */

public class OverviewScreen extends VBox  {
	private Customer customer;
    private ListView myListView;
	private SimpleStringProperty test = new SimpleStringProperty("");
	TableView<BankAccount[]> table;
	private ControllerEBanking controller;
	private String[] userAccounts;
	private LoginScreen loginScreen;
	private String selectedAccount;

    
    public OverviewScreen(ControllerEBanking controller) {
    	this.controller=controller;
	this.setId("OverviewScreen");
	


	userAccounts=controller.getUserAccounts(loginScreen.getTxtCustomerNumber());
	new ArrayList<>(Arrays.asList(userAccounts));
	
	VBox vbox = new VBox(10.0);
	vbox.setMinHeight(100);
	vbox.setMaxHeight(250);
	        Label lSelectAccount = new Label("Konto auswählen: ");
	        final ListView<String> accountList = new ListView<>();
	        accountList.getItems().addAll(userAccounts);
	        accountList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        	
	        	if (accountList.getSelectionModel().getSelectedItem() != null) {
					controller.setSelectedBankAccount(newValue);
				}
	        });
	        HBox hbox=new HBox();
	        Button bTransfer = new Button("Geld überweisen");
	        bTransfer.setOnAction(event -> {
	        	if (accountList.getSelectionModel().getSelectedItem() != null) {
	        		controller.goToTransferScreen();
	        	}
			});	        
	        Button bGetTransfers = new Button("Kontoauszug");
	        bGetTransfers.setOnAction(event -> {
	        	if (accountList.getSelectionModel().getSelectedItem() != null) {
				controller.nextScreen();
	        	}
			});
	        hbox.getChildren().addAll(bGetTransfers,bTransfer);
	    	vbox.getChildren().addAll(lSelectAccount,accountList,hbox);
	    	getChildren().addAll(vbox);
	    	vbox.setAlignment(Pos.CENTER);

	}


	public String getSelectedAccount() {
		return selectedAccount;
	}



		
	}



