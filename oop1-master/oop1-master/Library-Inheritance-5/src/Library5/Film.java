package Library5;

public final class Film extends DataObject {

	private static Actor[] actors;
	private String publisher;
	private int length;

	public Film(long articleNumber, String title, String publisher, int length) {
		super(articleNumber, title);
		this.publisher = publisher;
		this.length = length;
		actors = new Actor[3];
	}

	public static Actor[] getActors() {
		return actors;
	}

	public int getLength() {
		return length;
	}

	public void addActor(Actor actor, int i) {
		actors[i] = actor;
	}

	@Override
	public String toString() {
		return "Video:" + super.toString() + publisher.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		return false;
	}

}
