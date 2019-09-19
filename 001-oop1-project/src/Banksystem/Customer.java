package Banksystem;

public class Customer {
	/**
	 * Customer class
	 */
	private String usernumber;
	private String firstName;
	private String lastName;
	private String password;
	private String[] account = new String[16];
	private int accountCounter = 0;

	public Customer(String usernumber, String firstName, String lastName, String password) {
		this.usernumber = usernumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
/**
 * This method is implemented to add Account for a existe customer 
 * the user needs his account number
 * @param accountnumber
 */
	public void addAccount(String accountnumber) {
		account[accountCounter] = accountnumber;
		accountCounter++;
	}
/**
 * This method is implemented to delete  an Account which is no longer necessary
 * @param accountnumber
 */
	public void deleteAccount(String accountnumber) {
		int position = Integer.MAX_VALUE; // For finding the account to delete

		for (int i = 0; i < accountCounter; i++)
			if (account[i].equals(accountnumber)) {
				position = i;
				break;
			}

		if (position == Integer.MAX_VALUE)
			return;

		for (int i = position; i < accountCounter; i++)
			account[i] = account[i + 1];

		accountCounter--;
	}

	public String getUsernumber() {
		return usernumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public int getAccountLength() {
		return accountCounter;
	}

	public String[] getAccounts() {
		String[] allAccounts = new String[accountCounter];

		for (int i = 0; i < accountCounter; i++)
			allAccounts[i] = account[i];

		return allAccounts;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}