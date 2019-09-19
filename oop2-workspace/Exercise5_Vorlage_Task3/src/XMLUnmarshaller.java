import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import ch.bfh.fax.Fax;

public final class XMLUnmarshaller {

	private final static String PACKAGE = "ch.bfh.fax";
	private final static String XSD_FILE = "schema/fax.xsd";
	private final static String XML_FILE = "creat_Fax.xml";

	public static void main(String[] args) {

		if (!XMLValidation.XMLValidationString(XSD_FILE, XML_FILE)) {

			System.out.println("The XML File : " + XML_FILE + " is not valid against " + XSD_FILE);
			System.exit(0);
		} else {
			System.out.println("The XML File : " + XML_FILE + " is valid to the " + XSD_FILE);
		}

		try {
			JAXBContext context = JAXBContext.newInstance(PACKAGE);

			Unmarshaller unmarshaller = context.createUnmarshaller();

			Source source = new StreamSource(new FileInputStream(XML_FILE));

			JAXBElement<Fax> root = unmarshaller.unmarshal(source, Fax.class);

			Fax fax = root.getValue();

			System.out.print("READING the message : ");
			System.out.println(fax.getBody());
		} catch (JAXBException | FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
