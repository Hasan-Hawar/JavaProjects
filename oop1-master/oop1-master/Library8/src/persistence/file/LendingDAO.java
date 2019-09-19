package persistence.file;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.Logger;

import library.admin.Administration;
import library.admin.LendingManager;
import library.data.Customer;
import library.data.Item;
import library.data.Lending;


public class LendingDAO {
	
	Administration admin;
	Lending[] lendings;
	LendingManager lendingManager ;
	private File lendingFile;
	private String delimiter;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public LendingDAO(File lendingFile, String delimiter) {
		this.lendingFile = lendingFile;
		this.delimiter = delimiter;
		admin = Administration.getInstance();
		loadLendings();
	}

	private void loadLendings() {
		lendings = new Lending[26];
		log("load films");
		try (Scanner scanner = new Scanner(new FileReader(lendingFile))) {
			int nr = 0;
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				Customer customer = admin.getDataManager().getCustomers()[Integer.parseInt(tokens[0])];
				Item item = admin.getDataManager().findItem(Integer.parseInt(tokens[1]));
				LocalDate date = LocalDate.of(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
				Lending lending = new Lending(customer, item, date);
				 admin.addLending(customer, item, date);
				lendings[nr++] = lending;
				
				if (tokens.length > 5 && tokens[5] != null && !tokens[5].equals("")) {
				    LocalDate returnDate = LocalDate.of(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]));
				    admin.returnItem(item, returnDate);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Lending Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Lending Datei ist korrput");
		}
	}

	public Lending[] getLendings() {
		if (lendings == null)
			loadLendings();
		return lendings;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
}
