package Library.data;

import java.time.LocalDate;

public class Lending {

	private LocalDate startDate;
	private LocalDate returnDate;
	private Customer customer;
	private Item item;

	public Lending(Customer customer, Item item, LocalDate startDate) {
		this.startDate = startDate;
		this.customer = customer;
		this.item = item;
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

	public Item getItem() {
		return item;
	}

	@Override
	public String toString() {
		return "Lending from " + startDate + " of " + customer + ", " + item;
	}
}
