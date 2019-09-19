package Library;

public class Writer {
	private String firstName;
	private String lastName;

	public Writer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Writer other = (Writer) obj;
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
	 * public boolean equalWriter (Object obj1, Object obj2) {
	 * 
	 * if (((Writer)obj1).getClass() == ((Writer)obj2).getClass()) { return true; }
	 * if (((Writer)obj1).getfirstName() != ((Writer)obj2).getfirstName()) { return
	 * false; } if (((Writer)obj1).getlastName() != ((Writer)obj2).getlastName()) {
	 * return false; } return true; }
	 */

}
