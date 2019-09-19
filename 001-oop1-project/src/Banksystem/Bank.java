package Banksystem;

import java.io.IOException;

import extendedFunctions.Formatter;

/**
 * <h1>Bank<\h1>
 * This class is the bank and manages every input from the client and
 * returns all needed values.
 * 
 * @author Dmytriy Pelts
 * @version 1.0
 *
 */
public class Bank implements IATM, IEBanking, ICustomerService {
	// private final String name = "FirstBank";
	private final String id = "00";
	
	private CustomerManager customerManager;
	private AccountManager accountManager;
	
	public Bank()
	{
		customerManager = new CustomerManager();
		accountManager = new AccountManager();
	}

	/**
	 * Returns a requested account
	 * 
	 * @param accountNumber
	 * @return full account as a string/chain
	 */
	@Override
	public String getAccount(String accountNumber)
	{
		return accountManager.getAccountAsString(accountNumber);
	}

	/**
	 * Returns the transfers from the log file
	 * 
	 * @param accountNumber
	 * @return every line from the file
	 * @exception IOException
	 */
	@Override
	public String[] getTransfers(String accountNumber) throws IOException
	{	
		return FileManager.getAccountInfo(accountNumber);
	}

	/**
	 * Closes a specific account by removing it from the customer 
	 * and then write it in the account log
	 * 
	 * @param accountNumber
	 * @exception IOException
	 */
	@Override
	public void closeAccount(String accountNumber) throws IOException
	{
		// accountManager.closeAccount(accountNumber); 
		customerManager.removeAccount(accountNumber);
		AccountLogger.AccountWasClosed(accountNumber);
	}

	/**
	 * Finds the specific account and calculates the amount of money that should be added.
	 * Finally it makes an log entry.
	 * 
	 * @param accountNumber
	 * @param amount that should be added
	 * @return full account as a string/chain
	 */
	@Override
	public String depositMoney(String accountNumber, String amount)
	{
		double convertedAmount = Double.parseDouble(amount);
		BankAccount account = accountManager.getAccount(accountNumber);
		account.addMony(convertedAmount);
		
		
		try{ AccountLogger.MoneyWasAdded(accountNumber, amount); }
		catch (IOException e) {	System.err.println(e.getMessage()); }

		return accountManager.getAccountAsString(account);
	}

	
	/**
	 * Finds the specific account and calculates the amount of money that should be removed.
	 * Finally it makes an log entry.
	 * 
	 * @param accountNumber
	 * @param amount that should be removed
	 * @exception throws an Exception when a dailyLimit or the credit were hit.
	 * @return full account as a string/chain
	 */
	@Override
	public String payoffMoney(String accountNumber, String amount) throws BankLimitException
	{
		double convertedAmount = Double.parseDouble(amount);
		BankAccount account = accountManager.getAccount(accountNumber);
		account.removeMoney(convertedAmount);
		try { AccountLogger.MoneyWasRemoved(accountNumber, amount); }
		catch (IOException e) {	System.err.println(e.getMessage()); }
		
		return accountManager.getAccountAsString(account);
	}

	/**
	 * Finds the specific accounts and calculates the amount of money that should be added and removed depending on the accounts.
	 * Finally it makes an log entry to both accounts.
	 * 
	 * @param accountNumber
	 * @param amount that should be added
	 * @exception throws an Exception when a dailyLimit or the credit were hit.
	 */
	@Override
	public void transferMoney(String accountFrom, String accountTo, String amount) throws BankLimitException
	{
		double convertedAmount = Double.parseDouble(amount);
		accountManager.getAccount(accountFrom).removeMoney(convertedAmount);
		BankAccount account = accountManager.getAccount(accountTo);
		
		if(account.getNumber().substring(0, 1).equals(id))
			account.addMony(convertedAmount);
		
		try { AccountLogger.MoneyWasTransfered(accountFrom, accountTo, amount);}
		catch (IOException e) {	System.err.println(e.getMessage()); }
	}
	
	/**
	 * Creates a customer by deligating the task to the CustomerManager
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return full customer as a string/chain
	 */
	@Override
	public String createCustomer(String firstName, String lastName, String password)
	{
		try {	return customerManager.createCustomer(firstName, lastName, password); }		
		catch (IOException e) {	 System.out.println(e.getMessage()); }
		
		return null;
	}

	/**
	 * Delegates the account creation of a new account and logs it.
	 * 
	 * @param userNumber
	 * @param accountData (account as string)
	 * @return full account as a string/chain
	 */
	@Override
	public String createAccount(String userNumber, String accountData) throws IOException
	{
		String account = accountManager.createAccount(accountData);
		String accountnumber = Formatter.getSplitedString(account)[0];
		customerManager.addAccount(userNumber, accountnumber);
		AccountLogger.AccountWasCreated(accountnumber);
		
		return account;
	}

	/**
	 * Delegates the password change to the customer manager.
	 * 
	 * @param userNumber
	 * @param new password
	 * @return full customer as a string/chain
	 */
	@Override
	public String changeCustomerPassword(String userNumber, String newPassword) throws IOException
	{
		return customerManager.changePassword(userNumber, newPassword);
	}

	/**
	 * Let random generate a new pin for a specific account
	 * 
	 * @param accountNumber
	 * @return full account as a string/chain
	 */
	@Override
	public String changeAccountPin(String accountNumber) throws IOException
	{
		return accountManager.createNewPin(accountNumber);
	}

	/**
	 * Returns a specific customer.
	 * 
	 * @param customerNumber
	 * @return full customer as a string/chain
	 */
	@Override
	public String getCustomer(String userNumber) 
	{
		return customerManager.getFormattedCustomer(userNumber);
	}

	/**
	 * Returns all customer.
	 * (Not in use)
	 * 
	 * @return all customers as a string/chain
	 */
	@Override
	public String[] getAllCustomer() {
		
		return null;
	}
	
	/**
	 * Delegates verifications to the customer manager.
	 * 
	 * @param customerNumber
	 * @param password
	 * @return full customer as a string/chain
	 */
	@Override
	public String loginEBanking(String customerNumber, String password) 
	{
		return customerManager.verifyLogin(customerNumber, password);
	}

	/**
	 * Delegates verifications to the account.
	 * 
	 * @param accountNumber
	 * @param pin (of account)
	 * @return full account as a string/chain
	 */
	@Override
	public String loginATM(String accountNumber, String pin) 
	{
		return accountManager.verifyLogin(accountNumber, pin);
	}
}
