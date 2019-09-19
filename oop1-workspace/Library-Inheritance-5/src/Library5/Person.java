package Library5;

public class Person {

	protected String firstName;
	protected String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Writer) {
			Person p = (Person) obj;
			if (p.firstName != firstName)
				return false;
			if (p.lastName != lastName)
				return false;
			else
				return true;
		}
		return false;
	}

}
