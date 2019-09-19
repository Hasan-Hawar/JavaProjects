package library.admin;

import java.time.LocalDate;

import library.data.Customer;
import library.data.Item;
import library.data.Lending;
import library.data.State;

public class LendingManager {
	private Lending[] lendings;
	private int lendingCounter = 0;

	public LendingManager() {
		lendings = new Lending[50];
	}

	public Lending[] getLendings() {
		return lendings;
	}

	public boolean addLending(Customer customer, Item item, LocalDate date) {
		if (!item.isAvailable()) {
			return false;
		}
		item.setLending(new Lending(customer, item, date));
		item.setState(State.LENT);
		return true;
	}

	public boolean addLending(Lending lending) {
		Item item = lending.getItem();
		if (!item.isAvailable()) {
			return false;
		}
		lendings[this.lendingCounter++] = lending;
		item.setLending(lending);
		item.setState(State.LENT);
		return true;
	}

	public boolean returnItem(Item item, LocalDate date) {
		// Todo
		item.getLending().setReturnDate(date);
		item.setState(State.AVAILABLE);
		return true;
	}

	public boolean isAvailable(Item item) {
		return item.isAvailable();
	}

	public long[] getAvailableItems(long[] ids) {
		long[] result = null;
		// Todo
		for (long id : ids) {
			Item item = Administration.getInstance().findItem(id);
			if (item.isAvailable())
				result = Utils.addNumber(result, item.getId());
		}
		return result;
	}

	public LocalDate getLendingEndDate(Item item) {
		Lending lending = item.getLending();
		if (lending != null)
			return lending.getReturnDate();
		return LocalDate.now();
	}

	public LocalDate getTimeLimit(Item item) {
		Lending lending = item.getLending();
		if (lending != null)
			return lending.getTimeLimit();
		return LocalDate.now();
	}

	public void printLendings() {
		for (Lending l : lendings) {
			System.out.println(l.toString());
		}
	}

}
