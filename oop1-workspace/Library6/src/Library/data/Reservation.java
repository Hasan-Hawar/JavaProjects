package Library.data;
import java.time.LocalDate;

public class Reservation {

	Customer customer;
	DataObject object;
	LocalDate reservationDate;

	public Reservation(Customer customer, DataObject object, LocalDate reservationDate) {
		this.customer = customer;
		this.object = object;
		this.reservationDate = reservationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DataObject getObject() {
		return object;
	}

	public void setObject(DataObject object) {
		this.object = object;
	}

	public LocalDate getLocalDate() {
		return reservationDate;
	}

	public void setLocalDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Override
	public String toString() {
		return "Lending from " + reservationDate + " of " + customer + ", " + object;
	}

	
	
}
