import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Persons")
public final class Persons {

	@XmlAttribute
	private String version = "FS2019";

	@XmlElement(name = "Person")
	private List<Person> persons = new ArrayList<>();

	public void addPersons(Person person) {
		// TODO Auto-generated constructor stub
		persons.add(person);
	}

	/**
	 * @return the perons
	 */
	List<Person> getPersons() {
		return persons;
	}

}
