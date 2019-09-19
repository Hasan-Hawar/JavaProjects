package application;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

	private String firstname;
	private String lastname;
	private LocalDate birthdate;
	private CivilStatus civilStatus;

	public Person(String firstname, String lastname, LocalDate birthdate, CivilStatus civilStatus) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.civilStatus = civilStatus;
	}

	public Person(String line) {
		String[] value = line.split(",?\\s");
		firstname = value[0];
		lastname = value[1];
		birthdate = LocalDate.parse(value[2]);
		civilStatus = CivilStatus.valueOf(value[3]);
	}

	public void setMaritalStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (this.getClass() != other.getClass())
			return false;
		Person otherPerson = (Person) other;
		return Objects.equals(firstname, otherPerson.firstname) && Objects.equals(lastname, otherPerson.lastname)
				&& Objects.equals(birthdate, otherPerson.birthdate)
				&& Objects.equals(civilStatus, otherPerson.civilStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, lastname, birthdate, civilStatus);
	}

	@Override
	public String toString() {
		return firstname + " " + lastname + ", " + birthdate + ", " + civilStatus;
	}

}
