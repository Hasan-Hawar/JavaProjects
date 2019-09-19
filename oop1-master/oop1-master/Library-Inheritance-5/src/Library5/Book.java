package Library5;
import java.time.LocalDate;

public final class Book extends PrintMedium {

	private Writer writer;

	// boolean isAvailable = true;

	public Book(int ean, String title, Writer writer, int pages) {
		super(ean, title, pages);
		this.writer = writer;

	}

	public Writer getWriter() {
		return writer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Book:" + super.toString() + "" + writer;
	}

}
