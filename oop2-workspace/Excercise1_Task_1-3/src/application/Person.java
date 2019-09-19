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
	public String toString() {
		return lastname + " " + firstname + " , " + birthdate + ", " + civilStatus + " .";
	}

}
