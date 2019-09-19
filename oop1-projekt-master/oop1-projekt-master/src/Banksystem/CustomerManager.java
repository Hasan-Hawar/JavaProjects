package Banksystem;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import extendedFunctions.Formatter;

public class CustomerManager 
{
	private Map<String, Customer> customerDic;
	
	
	public CustomerManager()
	{
		customerDic = new HashMap<String, Customer>();
		readFromMemory();
	}
	
/**
 * This method is implemented to verify the Login for the user if the inputs(username , passsword) are correct or not	
 * @param usernumber
 * @param password
 * @return
 */
	public String verifyLogin(String usernumber, String password)
	{
		Customer customer = getCustomer(usernumber);
		
		if(customer.getPassword().equals(password))
			return getFormattedCustomer(customer);
		
		return null;
	}
	
/**
 * This method is implemented to save all accounts in an Array String to be able to access to the account if we want to make search to fine 
 * an specific account 	
 * @return
 */
	public String[] getAllCustomer()
	{
		String[] formattedCustomer = new String[customerDic.size()];
		int counter = 0;
		
		for(Customer customer : customerDic.values())
		{
			formattedCustomer[counter] = getFormattedCustomer(customer);
			counter++;
		}
		
		return formattedCustomer;
	}
/**
 *This method is implemented to have an account which we want to edit it or show 	
 * @param usernumber
 * @return
 */
	public Customer getCustomer(String usernumber)
	{
		return customerDic.get(usernumber);
	}
/**
 * This method is implemented to get the formatted account to String in the getFormattedCustomer
 * @param usernumber
 * @return
 */
	
	public String getFormattedCustomer(String usernumber)
	{
		Customer customer = customerDic.get(usernumber);
		String formattedCustomer = getFormattedCustomer(customer);
		
		return formattedCustomer;
	}
/**
 *This method is implemented to format the account to String which will splited by ";"
 * @param customer
 * @return
 */
	
	public String getFormattedCustomer(Customer customer)
	{
		String formattedCustomer = "";
		formattedCustomer += customer.getUsernumber() + ";";
		formattedCustomer += customer.getFirstName() + ";";
		formattedCustomer += customer.getLastName() + ";";
		formattedCustomer += customer.getPassword() + ";";
		
		int accountLength = customer.getAccountLength();
		if(accountLength == 0)
			return formattedCustomer;
		
		String[] accounts = customer.getAccounts();
		for (int i = 0; i < accountLength; i++)
		{
			formattedCustomer += accounts[i];
			if(i != (accountLength-1))
				formattedCustomer += ";";
		}
		
		return formattedCustomer;
	}
	
/**
 * This method is implemented to add an account for an exist Customer with void return
 * @param usernumber
 * @param accountnumber
 * @throws IOException
 */
	public void addAccount(String usernumber, String accountnumber) throws IOException
	{
		Customer customer = customerDic.get(usernumber);
		customer.addAccount(accountnumber);

		String formattedCustomer = getFormattedCustomer(customer);
		FileManager.UpdateCustomer(formattedCustomer);
	}

/**
 * This method is implemented to read from memory to get the customer information which we want
 */
	
	private void readFromMemory()
	{
		try
		{
			String[] lines = FileManager.getAllCustomer();
			for(int i = 0; i < lines.length; i++)
			{
				Customer customer = formatToCustomer(lines[i]);
				customerDic.put(customer.getUsernumber(), customer);
			}
		} 
		catch (IOException e) { System.err.println(e); }
	}
	
/**
 * This method is implemented to format the unformated customer to split it by ";"
 * @param unformattedValues
 * @return
 */
	private Customer formatToCustomer(String unformattedValues)
	{
		String[] token = Formatter.getSplitedString(unformattedValues);
		String usernumber = token[0];
		String password = token[1];
		String firstName = token[2];
		String lastName = token[3];
		Customer customer = new Customer(usernumber, firstName, lastName, password);
		
		if(token.length > 4)
			for (int i = 4; i < token.length; i++)
				customer.addAccount(token[i]);
		
		return customer;
	}
/**
 * This method is implemented to create a customer 	
 * @param firstname
 * @param lastname
 * @param password
 * @return
 * @throws IOException
 */
	
	public String createCustomer(String firstname, String lastname, String password) throws IOException 
	{
		int generatedNumber = FileManager.getAmountOfCustomer();
		generatedNumber++;
		
		String usernumber = Integer.toString(generatedNumber);
		String formattedValues = Formatter.getCombinedArgs(usernumber, firstname, lastname, password);
		
		FileManager.createCustomer(formattedValues);
		customerDic.put(usernumber, formatToCustomer(formattedValues));
		
		return formattedValues;
	}
	
/**
 * This method is implemented to remove an exist account	
 * @param accountnumber
 * @throws IOException
 */
	public void removeAccount(String accountnumber) throws IOException
	{
		Customer customer = findAccount(accountnumber);
		customer.deleteAccount(accountnumber);
		
		String formattedCustomer = getFormattedCustomer(customer);
		FileManager.UpdateCustomer(formattedCustomer);
	}
/**
 * This method is implemented to change the user password by enter the username and the old password 	
 * @param usernumber
 * @param password
 * @return
 * @throws IOException
 */
	
	public String changePassword(String usernumber, String password) throws IOException
	{
		Customer customer = customerDic.get(usernumber);
		customer.setPassword(password);
		
		String formattedCustomer = getFormattedCustomer(customer);
		FileManager.UpdateCustomer(formattedCustomer);
		
		return formattedCustomer;
	}
	
/**
 * This method is implemented to to be able to find an exist account by enter the accountNumber
 * @param accountnumber
 * @return
 */
	private Customer findAccount(String accountnumber)
	{
		for(Customer c : customerDic.values())
		{
			String[] accounts = c.getAccounts();
			for (int i = 0; i < c.getAccountLength(); i++)
				if(accounts[i].equals(accountnumber))
					return c;
		}	
		
		return null;
	}
}