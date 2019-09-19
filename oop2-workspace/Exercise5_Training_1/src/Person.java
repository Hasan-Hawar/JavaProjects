import java.time.LocalDate;
import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(propOrder = { "lastname", "firstname", "birthdate", "civilStatus" })
//@XmlAccessorType(XmlAccessType.FIELD)
public final class Person {
	@XmlElement(name = "Firstname", required = true)
	private String firstname;
	@XmlElement(name = "Name", required = true)
	private String lastname;
	@XmlElement(name = "Birthdate", required = true)
	@XmlSchemaType(name = "date")
	@XmlJavaTypeAdapter(value = LocalDate2XsdDateAdapter.class)
	private LocalDate birthdate;
	@XmlElement(name = "Maritalstatus", required = true)
	private CivilStatus civilStatus;

	public Person() {
	}

	public Person(String firstname, String lastname, LocalDate birthdate, CivilStatus civilStatus) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.civilStatus = civilStatus;
	}

//	public void setMaritalStatus(CivilStatus civilStatus) {
//		this.civilStatus = civilStatus;
//	}

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
		return firstname + " " + lastname + ", " + birthdate + ", " + civilStatus + " .";
	}

}
