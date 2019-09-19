package Library5;

public class Actor extends Person {

	public Actor(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Actor) {
			Actor a = (Actor) obj;
			if (a.firstName != firstName)
				return false;
			if (a.lastName != lastName)
				return false;
			else
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Actor: " + super.toString(); 
	}

}
