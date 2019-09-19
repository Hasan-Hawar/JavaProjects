package Banksystem;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import extendedFunctions.Formatter;

public class AccountManager 
{
	private Map<String, BankAccount> accountDic;

	public AccountManager()
	{
		accountDic = new HashMap<String, BankAccount>();
		readFromMemeory();
	}
/**
 * This method is implemented to read form the csv file the account and make the difference between the private account and saving account
 * and give the right one back
 */
	private void readFromMemeory()
	{
		try 
		{ 
			String[] lines = FileManager.getAllAccounts(); 
			for (int i = 0; i < lines.length; i++)
			{
				String[] token = Formatter.getSplitedString(lines[i]);
				BankAccount account = generateAccount(token);
				accountDic.put(token[0], account);
			}	
		} catch (IOException e) { System.err.println(e.getMessage()); }
	}

/**
 * This method is implemented to verify the loggin for the user by check the account number and pin code by ATM
 * @param accountnumber
 * @param pin
 * @return account as string if true
 */
	public String verifyLogin(String accountnumber, String pin)
	{
		BankAccount account = accountDic.get(accountnumber);
		
		if(account.getPin().equals(pin))
			return getAccountAsString(account);
		
		return null;
	}
/**
 * This method is implemented to return an exist account	
 * @param accountNumber
 * @return account from dictionary
 */
	public BankAccount getAccount(String accountNumber)
	{
		return accountDic.get(accountNumber);
	}
/**
 * This method is implemented to return an exist account as String 	
 * @param accountNumber
 * @return account as string
 */
	public String getAccountAsString(String accountNumber)
	{		
		BankAccount account = accountDic.get(accountNumber);
		return getAccountAsString(account);
	}
/**
 * This method is implemented to create an account for the new customer	
 * @param accountData
 * @return created account as string
 * @throws IOException
 */
	public String createAccount(String accountData) throws IOException 
	{
		String[] token = Formatter.getSplitedString(accountData);
		int totalAccountLength = FileManager.getAmountOfAccounts()+1;
		token[0] = "00"+token[0]+(Integer.toString(totalAccountLength));
		BankAccount account = generateAccount(token);
		account.setPin(generatePin());
		accountDic.put(token[0], account);
		
		String accountAsString = getAccountAsString(account);
		FileManager.createAccount(accountAsString);
		
		return accountAsString;
	}
/**
 * This method is implemented to save the update which is made on an account 
 * @param accountNumber
 * @throws IOException
 */
	public void saveSpecificAccount(String accountNumber) throws IOException
	{
		String dataToSave = getAccountAsString(accountNumber);
		FileManager.updateAccount(dataToSave);
	}
/**
 * This method is implemented to generate an account and save the infos in an array String and check if this account is
 *  private or saving account	
 * @param token
 * @return generated account
 */
	private BankAccount generateAccount(String[] token)
	{
		BankAccount account;
		
		String accountNumber = token[0];
		double balance = Double.parseDouble(token[1]);
		double interest = Double.parseDouble(token[2]);
		double creditLimit = Double.parseDouble(token[3]);
		double dailyLimit = Double.parseDouble(token[4]);
		String pin = token[5];
		
		if(token[0].charAt(2) == '1')
			account = new PrivateAccount(accountNumber, balance, interest, creditLimit, dailyLimit, pin);
		else
			account = new SavingAccount(accountNumber, balance, interest, creditLimit, dailyLimit, pin);
		
		accountDic.put(token[0], account);
		
		return account;
	}
/**
 * This method is implemented to splite an account infos and have it as String
 * @param account
 * @return Account as string
 */
	public String getAccountAsString(BankAccount account)
	{
		String result = "";
		result += account.getNumber() + ";";
		result += account.getBalance() + ";";
		result += account.getInterest() + ";";
		result += account.getCreditLimit() + ";";
		result += account.getDailyLimit() + ";";
		result += account.getPin();		
		
		return result;
	}
/**
 * This method is implemented to create a new Pin code for new customers 	
 * @param accountNumber
 * @return account as String
 * @throws IOException
 */
	public String createNewPin(String accountNumber) throws IOException
	{
		String newPin = generatePin();
		BankAccount account = accountDic.get(accountNumber);
		account.setPin(newPin);
		String dataToSave = getAccountAsString(account);
		FileManager.updateAccount(dataToSave);
		
		return dataToSave;
	}
/**
 * This method is implemented to generate the new pin code because we need it for the new customers	
 * @return generated pin as String
 */
	private String generatePin()
	{
		SecureRandom random = new SecureRandom();
		int accountPin = random.nextInt(9999);
		
		return Integer.toString(accountPin);
	}
}
