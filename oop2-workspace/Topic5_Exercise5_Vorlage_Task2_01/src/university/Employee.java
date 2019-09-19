package university;

public class Employee extends Person {

	private String department;

	public Employee() {
		super();
	}

	public Employee(String aName, String anEmail, String aDepartment) {
		super(aName, anEmail);
		department = aDepartment;
	}

	public String getDepartment() {
		return this.department;
	}

	public String getDescription() {
		return "Works in " + this.department;
	}

}
