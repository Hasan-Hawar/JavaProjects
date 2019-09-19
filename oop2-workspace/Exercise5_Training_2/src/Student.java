import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Student extends Person {

	@XmlElement
	private String grade;
	@XmlElement
	private String module;

	public Student() {
		super();
	}

	public Student(String aName, String anEmail, String aGrade, String module) {
		super(aName, anEmail);
		this.grade = aGrade;
		this.module = module;
	}

	public String getDescription() {
		return getName() + " is a " + grade + " grade student" + " of " + module + " .";
	}

	public String getGrade() {
		return grade;
	}

	public String getModule() {
		return module;
	}

}
