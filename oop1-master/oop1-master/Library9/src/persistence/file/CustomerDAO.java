package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Customer;
import persistence.ICustomerDAO;

public class CustomerDAO implements ICustomerDAO {
	private File customerFile;
	private String delimiter;
	private Customer[] customers;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public CustomerDAO(File customerFile, String delimiter) {
		this.customerFile = customerFile;
		this.delimiter = delimiter;
		loadCustomers();
	}

	private void loadCustomers() {
		customers = new Customer[15];
		log("load customers");
		try (Scanner scanner = new Scanner(new FileReader(customerFile))) {
			int nr = 0;
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				Customer customer = new Customer(tokens[0], tokens[1], tokens[2]);
				customers[nr++] = customer;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Customer Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Customer Datei ist korrput");
		}
	}
	public Customer[] getCustomers() {
		if (customers == null)
			loadCustomers();
		return customers;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}

}
