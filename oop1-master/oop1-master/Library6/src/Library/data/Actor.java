package Library.data;

public class Actor extends Person {

	public Actor(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public String toString() {
		return "Actor: " + super.toString();
	}
}
