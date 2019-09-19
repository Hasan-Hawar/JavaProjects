package Library.data;


public final class Music extends DataObject {

	private String bandName;
	private int length;

	public Music(long articleNumber, String title, String bandName, int length) {
		super(articleNumber, title);

		this.bandName = bandName;
		this.length = length;
	}

	public String getBandName() {
		return bandName;
	}

	public int getLength() {
		return length;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (bandName == null) {
			if (other.bandName != null)
				return false;
		} else if (!bandName.equals(other.bandName))
			return false;
		if (length != other.length)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Music [bandName :" + bandName + ", length: " + length + ", ArticleNumber:" + getArticleNumber()
				+ ", Title:" + getTitle() + "]";
	}

}
