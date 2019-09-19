import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ProductJaxb {

	public void marshall() {
		try {
			Product product = new Product("xc123b", "0101q");
			JAXBContext jc = JAXBContext.newInstance(Product.class);

			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(product, System.out);
			marshaller.marshal(product, new File("product.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void marshallList() {
		try {

			List<Product> listProduct = new ArrayList<Product>();
			listProduct.add(new Product("123000", "XBN01210"));
			listProduct.add(new Product("0012320", "AMZKJ2154"));
			listProduct.add(new Product("xc123b", "0101q"));

			ListProduct products = new ListProduct();
			products.setListProduct(listProduct);
			// Product product = new Product("xc123b", "0101q");
			JAXBContext jc = JAXBContext.newInstance(ListProduct.class);

			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(products, System.out);
			marshaller.marshal(products, new File("productList.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void unmarshall() {

		try {
			JAXBContext context = JAXBContext.newInstance(Product.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Product product = (Product) unmarshaller.unmarshal(new File("product.xml"));
			System.out.println("==========================================");
			System.out.println("ID: " + product.getId() + ", Number: " + product.getNumber());

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unmarshallList() {

		try {
			JAXBContext context = JAXBContext.newInstance(ListProduct.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ListProduct products = (ListProduct) unmarshaller.unmarshal(new File("productList.xml"));
			System.out.println("===================List Information=======================");
			for (Product product : products.getListProduct()) {
				System.out.println("ID: " + product.getId() + ", Number: " + product.getNumber());
			}

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
