package Library5;


public final class Journal extends PrintMedium {

	private String publisher;

	public Journal(long articleNumbr, String title, String publisher, int pages) {
		super(articleNumbr, title, pages);
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public String toString() {
		return super.toString() + "publisher: " + publisher;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		return false;
	}

}
