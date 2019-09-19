package Library;

import java.time.LocalDate;

public final class Book {

	final int ean;
	final String title;
	final Writer writer;
	final int pages;
	boolean isAvailable = true;

	public Book(int ean, String title, Writer writer, int pages) {
		this.title = title;
		this.ean = ean;
		this.pages = pages;
		this.writer = writer;

	}

	public Writer getWriter() {
		return writer;
	}

	public int getPages() {
		return pages;
	}

	public String getTitle() {
		return title;
	}

	public int getEan() {
		return ean;
	}

	/*
	 * public boolean getIsAvailable(LocalDate startDate, LocalDate returnDate) { if
	 * (returnDate.isBefore(LocalDate.now()) || returnDate.equals(LocalDate.now())
	 * || returnDate != null) { isAvailable = false; } else isAvailable = true;
	 * return isAvailable;
	 * 
	 * }
	 */

	public boolean equalBook(Object obj1, Object obj2) {
		if (obj1 == obj2) {
			return true;
		}
		if (obj1.getClass() != obj2.getClass()) {
			return false;
		}
		if (((Book) obj1).getEan() != ((Book) obj2).getEan()) {
			return false;
		}
		if (((Book) obj1).getPages() != ((Book) obj2).getPages()) {
			return false;
		}
		if (((Book) obj1).getTitle() != ((Book) obj2).getTitle()) {
			return false;
		}
		if (((Book) obj1).getWriter() != ((Book) obj2).getWriter()) {
			return false;
		}
		if (obj1 == null || obj2 == null) {
			return false;
		}

		return true;
	}

}
