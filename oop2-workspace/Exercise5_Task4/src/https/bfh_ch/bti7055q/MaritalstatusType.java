//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.24 at 08:09:09 PM CEST 
//


package https.bfh_ch.bti7055q;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MaritalstatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MaritalstatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SINGLE"/&gt;
 *     &lt;enumeration value="MARRIED"/&gt;
 *     &lt;enumeration value="CIVIL_PARTNERSHIP"/&gt;
 *     &lt;enumeration value="DIVORCED"/&gt;
 *     &lt;enumeration value="WIDOWED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MaritalstatusType")
@XmlEnum
public enum MaritalstatusType {

    SINGLE,
    MARRIED,
    CIVIL_PARTNERSHIP,
    DIVORCED,
    WIDOWED;

    public String value() {
        return name();
    }

    public static MaritalstatusType fromValue(String v) {
        return valueOf(v);
    }

}
