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

		Persons persons = new Persons();
		Person p1 = new Person("Hawar", "Hasan", LocalDate.of(1992, 02, 14), CivilStatus.Single);
		Person p2 = new Person("Hawar", "Bilal", LocalDate.of(1991, 06, 9), CivilStatus.Single);
		persons.addPersons(p1);
		persons.addPersons(p2);

		JAXBContext context = JAXBContext.newInstance(Persons.class);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", true);
		marshaller.marshal(persons, System.out);
		try (OutputStream out = new FileOutputStream("person.xml")) {
			marshaller.marshal(persons, out);
		}

		Unmarshaller unmarshaller = context.createUnmarshaller();
		try (InputStream in = new FileInputStream("person.xml")) {
			persons = (Persons) unmarshaller.unmarshal(in);
			System.out.println();
			System.out.println("Persons read from persons.xml");
			System.out.println("=============================");
			persons.getPersons().forEach(person -> System.out.println(person));
		}
	}
}
