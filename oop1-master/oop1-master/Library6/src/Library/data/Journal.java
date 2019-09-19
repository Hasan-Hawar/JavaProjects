package Library.data;


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
		return "Journal [publisher=" + publisher + ", getPages()=" + getPages() + ", getArticleNumber()="
				+ getArticleNumber() + ", getTitle()=" + getTitle() + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Journal other = (Journal) obj;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}


}
