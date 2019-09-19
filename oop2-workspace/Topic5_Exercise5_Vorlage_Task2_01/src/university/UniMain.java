package university;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public final class UniMain {

	private UniMain() {
	}

	private static final String UNIVERSITY_XML = "university.xml";

	public static void main(String[] args) throws IOException, JAXBException {

		// create some persons
		Student student = new Student("Max", "max@bfh.ch", "B");
		Student student2 = new Student("Tom", "tom@bfh.ch", "c");
		Professor prof = new Professor("Mr. X", "prof.x@bfh.ch", "IT Security");
		Employee empl = new Employee("Erni Schmidt", "erni.schmidt@bfh.ch", "HR");

		// create uni, assigning staff and students
		University bfh = new University("bfh");

		bfh.addStaff(student);
		bfh.addStaff(prof);
		bfh.addStaff(empl);

		bfh.addStudent(student);
		bfh.addStudent(student2);

		// create Marhaller and write to system.out and file university.xml
		// @TODO
		JAXBContext context = JAXBContext.newInstance(University.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		// Write to system ..
		m.marshal(bfh, System.out);
		// Write to File
		m.marshal(bfh, new File(UNIVERSITY_XML));

		// read the created XML file (unmarhall) and output the result
		// @TODO
		System.out.println();
		System.out.println("Output from out XML file ..");
		Unmarshaller um = context.createUnmarshaller();

		University uni = (University) um.unmarshal(new FileReader(UNIVERSITY_XML));

		List<Person> persons = uni.getStaff();
		if (persons != null) {
			System.out.println("STAFF");
			for (Person p : persons) {
				System.out.println("Person: " + p.getName() + " ," + p.getEmail());
			}
		}

		List<Student> st = uni.getStudents();
		if (st != null) {
			System.out.println("STUDENTS");
			for (Student s : st) {
				System.out.println("Student: " + s.getName() + " ," + s.getEmail() + " ," + s.getGrade() + " .");
			}
		}
	}
}
