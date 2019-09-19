package Banksystem.view.EBanking;

import java.io.IOException;
import java.rmi.RemoteException;

import Banksystem.BankLimitException;
import Banksystem.IEBanking;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * contain all the logistic aspect of the GUI
 *
 */
public class ControllerEBanking {
	private SimpleStringProperty dateSSP = new SimpleStringProperty("");
	private SimpleStringProperty descriptionSSP = new SimpleStringProperty("");
	private SimpleStringProperty amountSSP = new SimpleStringProperty("");
	ObservableList<String> transfersObList = FXCollections.observableArrayList("Date", "Description", "Amount");

	private MainEBanking main;
	protected int nr = 0;
	private int numberOfScreens = 4;
	private String username;
	private String password;
	private IEBanking ieBanking;
	private String selectedBankAccount;
	private ControllerEBanking controller;
	private String customerNumber;
	private String[] userAccounts;
	private String account;
	private String[] transfers;
	private String transferFromAccount;
	private String transferToAccount;
	private String amount;

	public ControllerEBanking(IEBanking ieBanking) throws Exception {
		this.ieBanking = ieBanking;
	}
/**
 * implement the login method of the EBanking interface
 * @param customerNumber: customer number entered by the user
 * @param password: password entered by the user
 * @exception return a NullPointerException if something is going wrong in the method and RemoteException if the  remote method calls failed
 * @return customerNumber: customer is a string that contains all the information of the customer
 */
	public String loginEBanking(String customerNumber, String password)  {
		try {
			this.customerNumber = customerNumber;
			this.password = password;	
			customerNumber = ieBanking.loginEBanking(customerNumber, password);
		} catch (NullPointerException|RemoteException e) {
			System.out.println("Die gegebene Informationen sind nicht gültig");
		}
		return customerNumber;
	}
/**
 * this method allow to get all the information od an account
 * @param customerNumber
 * @exception return a NullPointerException if something is going wrong in the method and RemoteException if the  remote method calls failed
 * @return username
 */
	public String getAccount(String customerNumber) {
		try {
			this.customerNumber = customerNumber;
			username = ieBanking.getAccount(customerNumber);
		} catch (NullPointerException|RemoteException e) {
			System.out.println("Ein Fehrler ist beim Suche von Kundenkonten entstanden");
		}
		return username;

	}
/**
 * this method allow to get all the account of a user
 * @param username
 * @return userAccounts: String that contain all the accounts
 */
	public String[] getUserAccounts(String username) {
		this.username = username;
		String[] usernameInfo = username.split(";");
		for (int i = 3; i < usernameInfo.length; i++) {
			userAccounts[i - 3] = usernameInfo[i];
		}
		return userAccounts;
	}
/**
 * this method allow to get all transfer of an account
 * @param accountNumber
 * @exception return a IOexeption and RemoteException if the  remote method calls failed
 * @return transfers: contain all the transfers
 */
	public String[] getTransfers(String accountNumber) {
		try {
			this.account = accountNumber;
			String[] transfers = ieBanking.getTransfers(accountNumber);
		} catch (NullPointerException | IOException e) {
			System.out.println("Ein fehler ist beim Suchen von Transfert entstanden");
		}
		return transfers;
	}
/**
 * this method allow to transfer an amount of money from one account to another one
 * @param accountFrom
 * @param accountTo
 * @param amount
 * @exception return a NullPointerException if something is going wrong in the method and RemoteException if the  remote method calls failed and a BankLimitExeption if the BankLimit is over
 */
	public void transferMoney(String accountFrom, String accountTo, String amount) {
		try {
			this.transferFromAccount = accountFrom;
			this.transferToAccount = accountTo;

			ieBanking.transferMoney(accountFrom, accountTo, amount);
		} catch (NullPointerException | RemoteException e) {
			System.out.println("Ein fehler ist bei der Überweisung entstanden");
		} catch (BankLimitException e) {
			System.out.println("Kontolimite wurde überschritten");
		}

	}
/**
 * this method allow to get to the next screen of the GUI
 */
	public void nextScreen() {
		main.clearScreen();
		nr = ++nr % numberOfScreens;
		if (nr == 0) {
			this.resetAllProperties();
		}
		main.addScreen(nr);

	}
/**
 * this method reset all properties
 */
	public void resetAllProperties() {
		this.getDate().set("");
		this.getDescription().set("");
		this.getAmount().set("");
	}

	public int getNr() {
		return nr;
	}

	public void decNr(int nr) {
		this.nr = nr;
		nr--;
		main.clearScreen();
		main.addScreen(nr);
	}

	public void goToTransferScreen() {
		nr = 3;
		main.clearScreen();
		main.addScreen(nr);
	}

	public void setMain(MainEBanking main) {
		this.main = main;
	}

	public int getNumberOfScreens() {
		return numberOfScreens;
	}

	public ControllerEBanking getController() {
		return controller;
	}

	public ObservableList<String> getTransfers() {
		return transfersObList;
	}

	public SimpleStringProperty getDate() {
		return dateSSP;
	}

	public void setDate(SimpleStringProperty date) {
		this.dateSSP = date;
	}

	public SimpleStringProperty getDescription() {
		return descriptionSSP;
	}

	public void setDescription(SimpleStringProperty description) {
		this.descriptionSSP = description;
	}

	public SimpleStringProperty getAmount() {
		return amountSSP;
	}

	public void setAmount(SimpleStringProperty amount) {
		this.amountSSP = amount;
	}

	public String getSelectedBankAccount() {
		return selectedBankAccount;
	}

	public void setSelectedBankAccount(String selectedBankAccount) {

		this.selectedBankAccount = selectedBankAccount;
	}
}
