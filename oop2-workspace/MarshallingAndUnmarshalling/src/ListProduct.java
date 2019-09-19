import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductsList")
public class ListProduct {

	private List<Product> listProduct = new ArrayList<Product>();

	public ListProduct(List<Product> listProduct) {
		// TODO Auto-generated constructor stub
		this.listProduct = listProduct;
	}

	public ListProduct() {
		super();
	}

	@XmlElement(name = "Product")
	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
