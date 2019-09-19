package Library.data;

public class Item {

	private long id;
	private State state;
	private Lending lending;
	private DataObject object;

	public Item(long id, DataObject object) {
		this.id = id;
		this.object = object;
		this.state = State.AVAILABLE;
	}

	public long getId() {
		return id;
	}

	public boolean isAvailable() {
		if (state == State.AVAILABLE) {
			return true;
		}
		return false;
	}

	public DataObject getDataObject() {
		return object;
	}

	public Lending getLending() {
		return lending;
	}

	public void setLending(Lending lending) {
		this.lending = lending;
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
		if (lending == null) {
			if (other.lending != null)
				return false;
		} else if (!lending.equals(other.lending))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item:" + id + "State: " + state + "Lending :" + lending;
	}

	public enum State {
		AVAILABLE, LENT, DAMAGED, RESERVED
	}
}
