package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Journal;

public class JournalDAO {
	private File journalFile;
	private String delimiter;
	private Journal[] journals;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public JournalDAO(File journalFile, String delimiter) {
		this.journalFile = journalFile;
		this.delimiter = delimiter;
		loadJournals();
	}

	private void loadJournals() {
		journals = new Journal[20];
		log("load journals");
		try (Scanner scanner = new Scanner(new FileReader(journalFile))) {
			int nr = 0;
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				int ean = Integer.parseInt(tokens[0]);
				int pages = Integer.parseInt(tokens[3]);
				Journal journal = new Journal(ean, tokens[1], tokens[2], pages);
				journals[nr++] = journal;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Journal Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Journal Datei ist korrput");
		}
	}

	public Journal[] getJournals() {
		if (journals == null)
			loadJournals();
		return journals;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
}
