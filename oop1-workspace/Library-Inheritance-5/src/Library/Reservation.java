package Library;

import java.time.LocalDate;

public class Reservation {

	Customer customer;
	Object object;
	LocalDate localDate;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Reservation(Customer customer, Object object, LocalDate localDate) {
		this.customer = customer;
		this.object = object;
		this.localDate = localDate;
	}

}
