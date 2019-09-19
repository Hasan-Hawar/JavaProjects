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

	public static void main(String[] args) throws JAXBException, IOException {

		// create some persons
		Student student = new Student("Max", "max@bfh.ch", "B", "OOP1");
		Student student2 = new Student("Tom", "tom@bfh.ch", "c", "OOP1");
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

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(bfh, System.out);
		marshaller.marshal(bfh, new File(UNIVERSITY_XML));

		// read the created XML file (unmarhall) and output the result
		// @TODO

		System.out.println();
		System.out.println("================================");
		System.out.println("... Outout from our XML File ...");
		System.out.println("================================");

		Unmarshaller unmarshaller = context.createUnmarshaller();

		University university = (University) unmarshaller.unmarshal(new FileReader(UNIVERSITY_XML));

		List<Person> staff = university.getStaff();
		if (staff != null) {
			System.out.println("Our Staff ");
			System.out.println("=========");
			for (Person person : staff) {
				System.out.println("Person:" + person.getName() + "; " + person.getEmail());
			}
		}
		List<Student> students = university.getStudents();
		if (students != null) {
			System.out.println("Our Students");
			System.out.println("============");
			for (Student st : students) {
				System.out.println("Student: " + st.getName() + "; " + st.getEmail() + "; " + st.getGrade() + "; "
						+ st.getModule());
			}
		}
	}
}
