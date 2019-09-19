package Library;

public final class Film {
	/*
	 * final int ean; final String title; final String publisher; final int length;
	 * final Actor actors;
	 */
	private Actor actors;
	private long articleNumber;
	protected String title;
	private String publisher;
	private int length;
	boolean isAvailable = true;

	public Film(long articleNumber, String title, String publisher, int length) {
		this.articleNumber = articleNumber;
		this.title = title;
		this.publisher = publisher;
		this.length = length;
		this.actors = actors;
	}

	public Actor getActors() {
		return actors;
	}

	public String getTitle() {
		return title;
	}

	public long getArticleNumber() {
		return articleNumber;
	}

	public int getLength() {
		return length;
	}

	public void addActor(Actor actor, int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (articleNumber != other.articleNumber)
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (length != other.length)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/*
	 * public boolean getIsAvailable(LocalDate startDate, LocalDate returnDate) { if
	 * (returnDate.isBefore(LocalDate.now()) || returnDate.equals(LocalDate.now())
	 * || returnDate != null) { isAvailable = false; } else isAvailable = true;
	 * return isAvailable; }
	 */

	/*
	 * public boolean equalFilm (Object obj1 , Object obj2) {
	 * 
	 * if(((Film)obj1).getClass() == ((Film)obj2).getClass()) { return true; }
	 * if(((Film)obj1).getActors() != ((Film)obj2).getActors()) { return false; }
	 * if(((Film)obj1).getArticleNumber() != ((Film)obj2).getArticleNumber()) {
	 * return false; } if(((Film)obj1).getLength() != ((Film)obj2).getLength()) {
	 * return false; } if(((Film)obj1).getTitle() != ((Film)obj2).getTitle()) {
	 * return false; } return true; }
	 */
}
