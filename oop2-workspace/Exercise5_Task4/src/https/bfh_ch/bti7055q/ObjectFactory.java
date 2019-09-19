//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.24 at 08:09:09 PM CEST 
//


package https.bfh_ch.bti7055q;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.bfh_ch.bti7055q package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Persons_QNAME = new QName("https://bfh.ch/BTI7055q", "Persons");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.bfh_ch.bti7055q
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PersonsType }
     * 
     */
    public PersonsType createPersonsType() {
        return new PersonsType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonsType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonsType }{@code >}
     */
    @XmlElementDecl(namespace = "https://bfh.ch/BTI7055q", name = "Persons")
    public JAXBElement<PersonsType> createPersons(PersonsType value) {
        return new JAXBElement<PersonsType>(_Persons_QNAME, PersonsType.class, null, value);
    }

}
