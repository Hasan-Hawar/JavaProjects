package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Book;
import library.data.Writer;

public class BookDAO {

	private File bookFile;
	private String delimiter;
	private Book[] books;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public BookDAO(File bookFile, String delimiter) {
		this.bookFile = bookFile;
		this.delimiter = delimiter;
		loadBooks();
	}

	private void loadBooks() {
		books = new Book[15];
		Writer[] w = createWriters();
		log("load books");
		try (Scanner scanner = new Scanner(new FileReader(bookFile))) {
			int nr = 0;
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				int ean = Integer.parseInt(tokens[0]);
				int pages = Integer.parseInt(tokens[2]);
				Book book = new Book(ean, tokens[1], pages);
				int writer = Integer.parseInt(tokens[3]);
				book.setWriter(w[writer]);
				books[nr++] = book;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Book Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Book Datei ist korrupt");
		}
	}

	public Book[] getBooks() {
		if (books == null) {
			loadBooks();
		}
		return books;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}

	private Writer[] createWriters() {
		Writer[] w = new Writer[7];
		w[0] = new Writer("Schreiberin", "Barbara");
		w[1] = new Writer("Schreiber", "Hans");
		w[2] = new Writer("Schreiber", "Peter");
		w[3] = new Writer("Schreiber", "Willi");
		w[4] = new Writer("Schreiberin", "Anna");
		return w;
	}

}
