package Library5;
import java.time.LocalDate;

public class Reservation {

	Customer customer;
	Object object;
	LocalDate reservationDate;

	public Reservation(Customer customer, Object object, LocalDate localDate) {
		this.customer = customer;
		this.object = object;
		this.reservationDate = localDate;
	}

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
		return reservationDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.reservationDate = localDate;
	}

	@Override
	public String toString() {
		return "Lending from " + reservationDate + " of " + customer + ", " + object;
	}

	
	
}
