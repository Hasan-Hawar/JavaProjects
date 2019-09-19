package Library.data;

public class BookItem extends Item {

	private Book book;

	public BookItem(long id, Book book) {
		super(id, book);
		this.book = (Book) this.getDataObject();
	}

	public Book getBook() {
		return book;
	}
	@Override
	public String toString() {
		return "Book:" + book +"ID: "+ getId() +"Status: " +  isAvailable() +"Lending: "+ getLending();
	}
}