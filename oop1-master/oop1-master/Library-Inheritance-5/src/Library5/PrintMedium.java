package Library5;

public class PrintMedium extends DataObject {

	private int pages;

	public PrintMedium(long articleNumber, String title, int pages) {
		super(articleNumber, title);
		this.pages = pages;
	}

	public int getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return super.toString() + "pages =" + pages;
	}

}
