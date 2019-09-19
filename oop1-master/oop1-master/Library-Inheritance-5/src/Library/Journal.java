package Library;

import java.time.LocalDate;

public final class Journal {

	final long articleNumbr;
	final String title;
	final String publisher;
	final int pages;
	boolean isAvailable = true;

	public Journal(long articleNumbr, String title, String publisher, int pages) {
		this.articleNumbr = articleNumbr;
		this.title = title;
		this.publisher = publisher;
		this.pages = pages;
	}

	public long getArticleNumbr() {
		return articleNumbr;
	}

	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPages() {
		return pages;
	}

	/*public boolean getIsAvailable(LocalDate startDate, LocalDate returnDate) {
		if (returnDate.isBefore(LocalDate.now()) || returnDate.equals(LocalDate.now()) || returnDate != null) {
			isAvailable = false;
		} else
			isAvailable = true;
		return isAvailable;
	}
*/
	
	public boolean equalJournal (Object obj1 , Object obj2) {
		
		if (((Journal)obj1).getClass() == ((Journal)obj2).getClass()) {
			return true;
		}
		
		if (((Journal)obj1).getArticleNumbr() != ((Journal)obj2).getArticleNumbr()) {
			return false;
		}
		if (((Journal)obj1).getPages() != ((Journal)obj2).getPages()) {
			return false;
		}
		if (((Journal)obj1).getPublisher() != ((Journal)obj2).getPublisher()) {
			return false;
		}
		if (((Journal)obj1).getTitle() != ((Journal)obj2).getTitle()) {
			return false;
		}
		return true;
		
		
	}
}
