package Library5;


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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Music:" + super.toString() + " " + bandName;
	}

}
