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

	private void setCivilSataus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	@Override
	public int hashCode() {

		return Objects.hash(firstname, lastname, birthdate, civilStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (civilStatus != other.civilStatus)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return lastname + " , " + firstname + " , " + birthdate + ", " + civilStatus + " .";
	}

}
