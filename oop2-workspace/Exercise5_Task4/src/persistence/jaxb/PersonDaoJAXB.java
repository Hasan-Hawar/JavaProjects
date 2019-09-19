package persistence.jaxb;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import https.bfh_ch.bti7055q.MaritalstatusType;
import https.bfh_ch.bti7055q.ObjectFactory;
import https.bfh_ch.bti7055q.PersonType;
import https.bfh_ch.bti7055q.PersonsType;
import model.MaritalStatus;
import model.Person;
import persistence.PersistenceException;
import persistence.PersonDAO;

public class PersonDaoJAXB implements PersonDAO {

	private static final String SCHEMA_LOCATION_ATTRIBUTE_VALUE = "https://bfh.ch/BTI7055q Schema/Persons.xsd";
	private static final String JAXB_CONTEXT_NAME = "https.bfh_ch.bti7055q";
	private File file;
	private JAXBContext jaxbContext;

	public PersonDaoJAXB(File file) throws PersistenceException {
		// TODO Auto-generated constructor stub
		this.file = file;
		try {
			jaxbContext = JAXBContext.newInstance(JAXB_CONTEXT_NAME);
		} catch (JAXBException e) {
			// TODO: handle exception
			throw new PersistenceException("Internal Error : ", e);
		}

	}

	@Override
	public void save(List<Person> persons) throws PersistenceException {
		// TODO Auto-generated method stub
		ObjectFactory factory = new ObjectFactory();
		try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
			Marshaller marshaller = CreateMarshaller();
			PersonsType personsXML = factory.createPersonsType();
			personsXML.setVersion("FS2018");
			for (Person person : persons) {
				PersonType personXML = factory.createPersonType();
				copyPerosnData(person, personXML);
				personsXML.getPerson().add(personXML);
			}
			JAXBElement<PersonsType> personsElement = factory.createPersons(personsXML);
			marshaller.marshal(personsElement, out);

		} catch (IOException | JAXBException | DatatypeConfigurationException e) {
			throw new PersistenceException("Error while saving to file : ", e);
		}

	}

	@Override
	public List<Person> load() throws PersistenceException {
		// TODO Auto-generated method stub]
		ArrayList<Person> persons = new ArrayList<>();
		try (FileReader in = new FileReader(file)) {
			Unmarshaller unmarshaller = createUnMarshaller();
			JAXBElement<PersonsType> personsElement = (JAXBElement<PersonsType>) unmarshaller.unmarshal(in);
			for (PersonType personXML : personsElement.getValue().getPerson()) {
				Person person = creatPerosnFromPersonType(personXML);
				persons.add(person);
			}
		} catch (IOException | JAXBException | SAXException e) {
			throw new PersistenceException("Error while loading data from file  : " + file.getAbsolutePath(), e);
		}

		return persons;

	}

	private Marshaller CreateMarshaller() throws JAXBException {
		// TODO Auto-generated method stub
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, SCHEMA_LOCATION_ATTRIBUTE_VALUE);
		return marshaller;
	}

	private Unmarshaller createUnMarshaller() throws JAXBException, SAXException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
				.newSchema(new File("Schema/persons.xsd"));
		unmarshaller.setSchema(schema);
		return unmarshaller;
	}

	private void copyPerosnData(Person person, PersonType personXML) throws DatatypeConfigurationException {
		personXML.setName(person.getLastname());
		personXML.setFirstname(person.getFirstname());
		personXML.setMaritalstatus(MaritalstatusType.fromValue(person.getMaritalStatus().toString()));
		GregorianCalendar calendar = GregorianCalendar.from(person.getBirthdate().atStartOfDay(ZoneId.systemDefault()));
		XMLGregorianCalendar xmlCalender = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
		personXML.setBirthdate(xmlCalender);
	}

	private Person creatPerosnFromPersonType(PersonType personXML) {
		String lastName = personXML.getName();
		String firstName = personXML.getFirstname();
		LocalDate birthdate = personXML.getBirthdate().toGregorianCalendar().toZonedDateTime().toLocalDate();
		MaritalStatus maritalStatus = MaritalStatus.valueOf(personXML.getMaritalstatus().toString());
		Person person = new Person(lastName, firstName, birthdate, maritalStatus);

		return person;
	}

}
