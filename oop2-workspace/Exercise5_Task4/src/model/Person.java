package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public final class Person implements Serializable {
	private static final long serialVersionUID = -1563771350254661623L;

	private String firstname;
	private String lastname;
	private LocalDate birthdate;
	private MaritalStatus maritalStatus;

	public Person(String firstname, String lastname, LocalDate birthdate, MaritalStatus maritalStatus) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.maritalStatus = maritalStatus;
	}

	/**
	 * Creates a Person object. The fields are initialized by parsing a line string.
	 * The line string must have the form
	 * <code>[firstname] [name], [birthdate], [marital status]</code>. Such strings
	 * are produced by <code>toString()</code>.
	 * 
	 * @param line The String to be parsed for field initialization.
	 * @throws IllegalArgumentException if line does not contain 4 tokens separated
	 *                                  by comma and/or whitespace or if fourth
	 *                                  token is not a valid marital status name
	 * @throws NullPointerException     if line or fourth token is null
	 * @throws DateTimeParseException   if third token is not a valid LocalDate
	 */
	public Person(String line) {
		String[] values = line.split("[,\\s]+");
		if (values.length != 4)
			throw new IllegalArgumentException(
					"Illegal number of tokens in line. Expected: 4: Actual: " + values.length);
		firstname = values[0];
		lastname = values[1];
		birthdate = LocalDate.parse(values[2]);
		maritalStatus = MaritalStatus.valueOf(values[3]);
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @return the birthdate
	 */
	public LocalDate getBirthdate() {
		return birthdate;
	}

	/**
	 * @return the maritalStatus
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
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
				&& Objects.equals(maritalStatus, otherPerson.maritalStatus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, lastname, birthdate, maritalStatus);
	}

	@Override
	public String toString() {
		return firstname + " " + lastname + ", " + birthdate + ", " + maritalStatus;
	}
}
