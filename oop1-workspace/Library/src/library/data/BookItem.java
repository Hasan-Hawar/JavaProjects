package library.data;

public class BookItem extends Item {
	private Book book;

	public BookItem(long id, Book book) {
		super(id);
		this.book = book;
	}	

	public Book getBook() {
		return book;
	}

	@Override
	public String toString() {
		return "Book: " + book + super.toString();
	}

	@Override
	public DataObject getDataObject() {
		// TODO Auto-generated method stub
		return getBook();
	}
}
