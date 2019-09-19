package Library5;

public class DataObject {

	private long articleNumber;
	private String title;

	public long getArticleNumber() {
		return articleNumber;
	}

	public String getTitle() {
		return title;
	}

	public DataObject(long articleNumber, String title) {
		this.articleNumber = articleNumber;
		this.title = title;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataObject other = (DataObject) obj;
		if (articleNumber != other.articleNumber)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
