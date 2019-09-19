package Banksystem.view.ATM;

import java.rmi.RemoteException;

import Banksystem.BankLimitException;
import Banksystem.IATM;
import javafx.beans.property.SimpleStringProperty;
/**
 * contain all the logistic aspect of the GUI
 *
 */
public class ControllerATM {
	private String AccountBalance;
	private SimpleStringProperty Kontonummer = new SimpleStringProperty("");
	private SimpleStringProperty password = new SimpleStringProperty("");
	private SimpleStringProperty betrag = new SimpleStringProperty("");
	private String accountNumber;
	private String pin;
	private String amount;
	private String account;
	private MainATM main;
	protected int nr = 0;
	private int numberOfScreens = 3;
	private IATM iatm;

	public ControllerATM(IATM iatm) throws Exception {
		this.iatm = iatm;
	}
/**
 * implement the login method of the atm interface
 * @param accountNumber: account number entered by the user
 * @param pin: pin number entered by the user
 * @exception return a NullPointerException if something is going wrong in the method and RemoteException if the  remote method calls failed
 * @return: String account: contain all the information of the account
 */
	public String loginATM(String accountNumber, String pin) {
		try {
			this.accountNumber = accountNumber;
			this.pin = pin;
			account = iatm.loginATM(accountNumber, pin);
		} catch (NullPointerException|RemoteException e) {
			System.out.println("Ein Fehler wurde während das Login entstanden");
		}
		return account;
	}
/**
 * the method allow to get the balance of a bankaccount
 * @param account: 
 *  * @exception return a NullPointerException if something is going wrong in the method 
 * @return AccountBalance: the balance of the account
 */
	public String getBalance(String account) {
		try {
			this.account = account;
			String[] accountInfo = account.split(";");
			AccountBalance = accountInfo[1];
		} catch (NullPointerException e) {
			System.out.println("Ein Fehler wurde bei getBalance entstanden");
		}
		return AccountBalance;
	}
/**
 * this method allow to pay off money from an account
 * @param accountNumber: account where we want to take money
 * @param amount: amount of money that we want to take
 *  * @exception return a BankLimitException if the bank limit is overtaked and RemoteException if the  remote method calls failed
 * @return boolean true/false: to see if the payoff succeed
 */
	public boolean payoffMoney(String accountNumber, String amount) {
		try {
			this.accountNumber = accountNumber;
			this.amount = amount;
			iatm.payoffMoney(accountNumber, amount);
		} catch (NullPointerException|BankLimitException|RemoteException e) {
			System.out.println("Ein Error ist während die Auszahlen entstanden");
		}

		return true;
	}
/**
 * allow to get to the next screen of the GUI
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
 * allow to reset all properties
 */
	public void resetAllProperties() {
		this.getKontonummer().set("");
		this.getPassword().set("");
		this.betrag.set("");
	}

	public SimpleStringProperty getPassword() {
		return password;
	}

	public SimpleStringProperty getKontonummer() {
		return Kontonummer;
	}

	public void setMain(MainATM main) {
		this.main = main;
	}

	public String getAccount() {
		return account;
	}

	public int getNumberOfScreens() {
		return numberOfScreens;
	}

}
