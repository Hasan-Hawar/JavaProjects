package university;

import java.util.ArrayList;
import java.util.List;

public class University {

	private String name;
	private List<Person> staff;
	private List<Student> students;

	public University() {
		name = "unknown";
		staff = new ArrayList<Person>();
		students = new ArrayList<Student>();
	}

	public University(String aName) {
		this();
		name = aName;
	}

	public String getName() {
		return name;
	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public void addStaff(Person p) {
		staff.add(p);
	}

	public List<Person> getStaff() {
		return staff;
	}

	public List<Student> getStudents() {
		return students;
	}

}
