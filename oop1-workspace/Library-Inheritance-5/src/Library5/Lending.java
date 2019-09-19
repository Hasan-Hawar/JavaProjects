package Library5;

import java.time.LocalDate;

public class Lending {

	private LocalDate startDate;
	private LocalDate returnDate;
	private Customer customer;
	private DataObject object;

	public Lending(Customer customer, DataObject object, LocalDate startDate) {
		this.startDate = startDate;
		this.customer = customer;
		this.object = object;
	}

	public LocalDate getStartDate() {

		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;

	}

	public LocalDate getTimeLimit() {
		return startDate.minusMonths(-1);
	}

	public Customer getCustomer() {
		return customer;
	}

	public DataObject getDataObject() {
		return object;
	}

	@Override
	public String toString() {
		return "Lending from " + startDate + " of " + customer + ", " + object;
	}
}
