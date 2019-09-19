package library.data;

public abstract class Item {
	private long id;
	private State state;
	private Lending lending;
	public Item(long id) {
		this.id = id;
		state = State.AVAILABLE;
	}

	public long getId() {
		return id;
	}
	
	public boolean isAvailable() {
		if (state.equals(State.AVAILABLE))
			return true;
		return false;
	}

	public Lending getLending() {
		return lending;
	}

	public void setLending(Lending lending) {
		this.lending = lending;
		state = State.LENT;
	}
	public abstract DataObject getDataObject();
	
	public String getTitel() {
		return getDataObject().getTitle();
	}
	
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item: " + id + state.name();
	}

	
}
