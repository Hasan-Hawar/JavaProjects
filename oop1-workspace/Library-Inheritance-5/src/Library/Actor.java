package Library;

public class Actor {
	private String firstName;
	private String lastName;

	public Actor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String fName) {
		this.firstName = fName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lName) {
		this.lastName = lName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	/*
	 * public boolean equalActors (Object obj1, Object obj2) {
	 * 
	 * if (((Actor)obj1).getClass() == ((Actor)obj2).getClass()) { return true; } if
	 * (((Actor)obj1).getfirstName() != ((Actor)obj2).getfirstName()) { return
	 * false; } if (((Actor)obj1).getlastName() != ((Actor)obj2).getlastName()) {
	 * return false; } return true; }
	 */

}
