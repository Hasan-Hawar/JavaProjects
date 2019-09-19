import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class PersonRegistry {

	public static void main(String[] args) throws JAXBException, FileNotFoundException, IOException {

		// CivilStatus civilStatus;
		Persons persons = new Persons();
		Person p1 = new Person("Hasan", "Hawar", LocalDate.of(1992, 2, 14), CivilStatus.Married);
		Person p2 = new Person("Fatima", "Hawar", LocalDate.of(1998, 7, 29), CivilStatus.Married);
		persons.addPersons(p1);
		persons.addPersons(p2);

		JAXBContext context = JAXBContext.newInstance(Persons.class);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", true);
		marshaller.marshal(persons, System.out);
		try (OutputStream out = new FileOutputStream("persons.xml")) {
			marshaller.marshal(persons, out);
		}

		Unmarshaller unmarshaller = context.createUnmarshaller();
		try (InputStream in = new FileInputStream("persons.xml")) {
			persons = (Persons) unmarshaller.unmarshal(in);
			System.out.println();
			System.out.println("Persons read from person.xml");
			System.out.println("==============================");
			// Person p = null;
			persons.getPersons().forEach(person -> System.out.println(person));
		}

	}

}
