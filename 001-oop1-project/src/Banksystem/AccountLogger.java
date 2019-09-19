package Banksystem;

import java.io.IOException;

import extendedFunctions.TimeManager;

/**
 * This class manages the Log files of all accounts
 * 
 * @author Dmytriy Pelts
 *@version 1.0
 */

public class AccountLogger {
/**
 * This method is implemented to save the actions for the money which is removed from the account
 * @param accountnumber
 * @param amount
 * @throws IOException
 */
	public static void MoneyWasRemoved(String accountnumber, String amount) throws IOException {
		String message = String.format("%s: Ein Betrag von %s wurde abgezogen.", TimeManager.getCurrentTime(), amount);
		FileManager.writeAccountLog(accountnumber, message);
	}
/**
 * This method is implemented to save the actions for the money which is added to the account
 * @param accountnumber
 * @param amount
 * @throws IOException
 */
	public static void MoneyWasAdded(String accountnumber, String amount) throws IOException {
		String message = String.format("%s: Ein Betrag von %s wurde gutgeschrieben.", TimeManager.getCurrentTime(),
				amount);
		FileManager.writeAccountLog(accountnumber, message);
	}
/**
 * This method is implemented to save the actions for the money which is transfered from account to another account
 * @param accountFrom
 * @param accountTo
 * @param amount
 * @throws IOException
 */
	public static void MoneyWasTransfered(String accountFrom, String accountTo, String amount) throws IOException {
		if (accountFrom.substring(0, 1) == "00") {
			String message = String.format("%s: Zum Konto %s wurde ein Betrag von %s überwiesen.",
					TimeManager.getCurrentTime(), accountTo, amount);
			FileManager.writeAccountLog(accountFrom, message);
		}
		if (accountTo.substring(0, 1) == "00") {
			String message = String.format("%s: Vom Konto %s wurde ein Betrag von %s gutgeschrieben.",
					TimeManager.getCurrentTime(), accountFrom, amount);
			FileManager.writeAccountLog(accountTo, message);
		}
	}
/**
 * This method is implemented to save the actions for the accounts which have created
 * @param accountNumber
 * @throws IOException
 */
	public static void AccountWasCreated(String accountNumber) throws IOException {
		String message = String.format("%s: Konto wurde erstellt.", TimeManager.getCurrentTime());
		FileManager.createAccountLog(accountNumber, message);
	}
/**
 * This method is implemented to save the actions for the accounts which have closed
 * @param accountNumber
 * @throws IOException
 */
	public static void AccountWasClosed(String accountNumber) throws IOException {
		String message = String.format("%s: Konto wurde archiviert.", TimeManager.getCurrentTime());
		FileManager.closeAccount(accountNumber, message);
	}
}