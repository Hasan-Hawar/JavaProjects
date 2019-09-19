import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
public class Product {

	private String number;
	private String id;

	public Product(String number, String id) {
		// TODO Auto-generated constructor stub

		this.number = number;
		this.id = id;
	}

	public Product() {
		super();
	}

	@XmlElement
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@XmlElement
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
