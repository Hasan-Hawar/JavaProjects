import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlSeeAlso({ Professor.class, Employee.class })
@XmlType(propOrder = { "name", "email" })
abstract public class Person {

	@XmlElement
	private String email;
	@XmlElement
	private String name;

	public Person() {
		email = "unkown";
		name = "unkown";
	}

	public Person(String aName, String anEmail) {
		email = anEmail;
		name = aName;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return "A person with name: " + name;
	}

}
