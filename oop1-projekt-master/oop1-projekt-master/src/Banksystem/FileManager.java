package Banksystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class handles the whole persistence.
 * @author Dmytriy Pelts
 * @version 1.0
 */
public class FileManager {
	/** We cache the paths and filenames */
	static String path = (System.getProperty("user.dir") + "\\src\\Banksystem\\persistance\\");
	final static String customerFilename = "Customer.csv";
	final static String accountFilename = "Account.csv";
	final static String accountLogPath = "Accountlog\\";

	/**
	 * Returns a specific user searched by usernumber
	 * @param usernumber
	 * @return user as string
	 * @throws IOException
	 */
	public static String getCustomer(String usernumber) throws IOException {
		return findLine(usernumber, customerFilename);
	}

	/**
	 * Returns all Customer which are saved
	 * @return array of strings (customer)
	 * @throws IOException
	 */
	public static String[] getAllCustomer() throws IOException {
		return readAllLines(customerFilename);
	}

	/**
	 * Returns a specific account searched by accountnumber
	 * @param number
	 * @return account as string
	 * @throws IOException
	 */
	public static String getAccount(String number) throws IOException {
		return findLine(number, accountFilename);
	}

	/**
	 * Returns all accounts which are saved
	 * @return array of strings (account)
	 * @throws IOException
	 */
	public static String[] getAllAccounts() throws IOException {
		return readAllLines(accountFilename);
	}

	/**
	 * Reads every line in a file, caches the read lines and returns them.
	 * @param filename
	 * @return array of strings
	 * @throws IOException
	 */
	private static String[] readAllLines(String filename) throws IOException {
		String[] lines = new String[64];
		BufferedReader reader = new BufferedReader(new FileReader(path + filename));

		int counter = 0;
		for (String line; (line = reader.readLine()) != null; counter++)
			lines[counter] = line;

		String[] result = new String[counter];
		for (int i = 0; i < counter; i++)
			result[i] = lines[i];

		reader.close();

		return result;
	}

	/**
	 * Finds a specific line in a specific file.
	 * @param number (account or customer)
	 * @param filename
	 * @return read line
	 * @throws IOException
	 */
	private static String findLine(String number, String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path + filename));
		String line = null;

		while ((line = reader.readLine()) != null)
			if (line.split(";")[0].equals(number))
				break;
		
		reader.close();
		return line;
	}

	/**
	 * Reads the log file of a specific account and returns the content as a string array.
	 * @param number
	 * @return array of string (content)
	 * @throws IOException
	 */
	public static String[] getAccountInfo(String number) throws IOException 
	{	
		String filename = accountLogPath + number;
		return readAllLines(filename);
	}

	/**
	 * Creates a customer with the given parameter.
	 * @param dataToSave
	 * @throws IOException
	 */
	public static void createCustomer(String dataToSave) throws IOException {
		writeNewLineToFile(dataToSave, customerFilename);
	}

	/**
	 * Creates an account with the given parameter.
	 * @param dataToSave
	 * @throws IOException
	 */
	public static void createAccount(String dataToSave) throws IOException {
		writeNewLineToFile(dataToSave, accountFilename);
	}

	/**
	 * Creates an account log when a account is created.
	 * @param accountNumber
	 * @param message
	 * @throws IOException
	 */
	public static void createAccountLog(String accountNumber, String message) throws IOException {
		String fileLocation = (accountLogPath + accountNumber + ".txt");

		File file = new File(path + fileLocation);
		if (file.exists())
			return;

		file.getParentFile().mkdirs();
		file.createNewFile();

		writeNewLineToFile(message, fileLocation);
	}

	/**
	 * Writes the given message in the a specific account log.
	 * @param accountNumber
	 * @param message
	 * @throws IOException
	 */
	public static void writeAccountLog(String accountNumber, String message) throws IOException {
		String fileLocation = (accountLogPath + accountNumber + ".txt");
		writeNewLineToFile(message, fileLocation);
	}

	/**
	 * Updates a specific line in the account.
	 * @param dataToSave
	 * @throws IOException
	 */
	public static void updateAccount(String dataToSave) throws IOException {
		UpdateLine(dataToSave, accountFilename);
	}

	/**
	 * Updates a specific line in the customer.
	 * @param dataToSave
	 * @throws IOException
	 */
	public static void UpdateCustomer(String dataToSave) throws IOException {
		UpdateLine(dataToSave, customerFilename);
	}

	/**
	 * Searches for a specific line and overrides it by first reading everything,
	 * change the line and over write the file.
	 * @param dataToSave
	 * @param filename
	 * @throws IOException
	 */
	private static void UpdateLine(String dataToSave, String filename) throws IOException {
		String numberToSearch = dataToSave.split(dataToSave)[0];
		BufferedReader reader = new BufferedReader(new FileReader(path + filename));
		int positionToSearch = Integer.MAX_VALUE;
		String currentLine = null;
		String[] lines = new String[64];

		for (int x = 0; (currentLine = reader.readLine()) != null; x++) {
			lines[x] = currentLine;
			if (currentLine.split(";")[0].equals(numberToSearch))
				positionToSearch = x;
		}
		reader.close();

		if (positionToSearch == Integer.MAX_VALUE)
			throw new IOException("Could not find Line");
		lines[positionToSearch] = dataToSave;

		BufferedWriter writer = new BufferedWriter(new FileWriter(path + filename, false));
		for (int x = 0; x < lines.length; x++) {
			writer.write(lines[x]);
			writer.newLine();
		}
		writer.close();
	}

	/**
	 * Writes a last message when the account is going to be closed.
	 * @param accountNumber
	 * @param message
	 * @throws IOException
	 */
	public static void closeAccount(String accountNumber, String message) throws IOException 
	{
		String fileLocation = (accountLogPath + accountNumber + ".txt");
		writeNewLineToFile(message, fileLocation);
	}

	/**
	 * Counts the amount of accounts
	 * @return amount of accounts
	 * @throws IOException
	 */
	public static int getAmountOfAccounts() throws IOException {
		return getAmountOfLines(accountFilename);
	}

	/**
	 * Counts the amount of customers
	 * @return amount of customers
	 * @throws IOException
	 */
	public static int getAmountOfCustomer() throws IOException {
		return getAmountOfLines(customerFilename);
	}

	/**
	 * Counts every line from a specific file
	 * @param file
	 * @return amount of lines
	 * @throws IOException
	 */
	private static int getAmountOfLines(String file) throws IOException {
		int counter = 0;
		BufferedReader reader = new BufferedReader(new FileReader(path + file));
		while (reader.readLine() != null)
			counter++;

		reader.close();

		return counter;
	}

	/**
	 * Writes a new line in a specific file
	 * @param dataToSave
	 * @param filename
	 * @throws IOException
	 */
	private static void writeNewLineToFile(String dataToSave, String filename) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path + filename, true));
		writer.append(dataToSave);
		writer.newLine();
		writer.close();
	}
}