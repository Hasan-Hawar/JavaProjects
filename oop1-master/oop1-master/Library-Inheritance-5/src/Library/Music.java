package Library;

import java.time.LocalDate;

public final class Music {
	final long articleNumber;
	final String title;
	final String bandName;
	final int length;
	boolean isAvailable = true;

	public Music(long articleNumber, String title, String bandName, int length) {
		this.articleNumber = articleNumber;
		this.title = title;
		this.bandName = bandName;
		this.length = length;
	}

	public long getArticleNumber() {
		return articleNumber;
	}

	public String getTitle() {
		return title;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (articleNumber != other.articleNumber)
			return false;
		if (bandName == null) {
			if (other.bandName != null)
				return false;
		} else if (!bandName.equals(other.bandName))
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (length != other.length)
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

}
