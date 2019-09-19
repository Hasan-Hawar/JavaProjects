import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ch.bfh.fax.Fax;
import ch.bfh.fax.FromTo;
import ch.bfh.fax.Header;
import ch.bfh.fax.ObjectFactory;
import ch.bfh.fax.Priority;

public class XMLMarshaller {

	private final static String Package = "ch.bfh.fax";
	private final static String xml_File = "creat_Fax.xml";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectFactory factory = new ObjectFactory();

		FromTo from = factory.createFromTo();
		from.setName("MyCompany");
		from.setFaxno(" 012 345 67 89 ");

		FromTo to = factory.createFromTo();
		to.setName("YourCompany");
		to.setFaxno(" 089 765 43 21 ");

		Header header = factory.createHeader();
		header.setFrom(from);
		header.setTo(to);
		header.setPriority(Priority.URGENT);
		header.setPages(1);

		Fax fax = new Fax();
		fax.setHeader(header);
		fax.setBody("This message in the Body of our Fax");

		File file = new File(xml_File);

		try {
			JAXBContext context = JAXBContext.newInstance(Package);

			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.bfh.ch/fax/ Schema\\fax.xsd");

			m.marshal(fax, file);
			m.marshal(fax, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
