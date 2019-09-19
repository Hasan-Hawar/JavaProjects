import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Professor extends Person {

	@XmlElement
	private String subject;

	public Professor() {
		super();
	}

	public Professor(String aName, String anEmail, String aSubject) {
		super(aName, anEmail);
		subject = aSubject;
	}

	public String getDescription() {
		return getName() + " teaches " + subject;
	}

}
