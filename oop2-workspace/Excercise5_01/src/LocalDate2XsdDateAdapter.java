import java.time.LocalDate;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class LocalDate2XsdDateAdapter extends XmlAdapter<XMLGregorianCalendar, LocalDate> {

	@Override
	public XMLGregorianCalendar marshal(LocalDate birthdate) throws Exception {
		// TODO Auto-generated method stub
		GregorianCalendar birthdateGregorian = new GregorianCalendar(birthdate.getYear(), birthdate.getMonthValue() - 1,
				birthdate.getDayOfMonth());
		XMLGregorianCalendar birthdateXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(birthdateGregorian);
		return birthdateXML;
	}

	@Override
	public LocalDate unmarshal(XMLGregorianCalendar birthdateXML) throws Exception {
		// TODO Auto-generated method stub
		LocalDate birthdate = LocalDate.of(birthdateXML.getYear(), birthdateXML.getMonth(), birthdateXML.getDay());
		return birthdate;
	}

}
