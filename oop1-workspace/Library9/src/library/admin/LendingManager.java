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

	public boolean addLending(Customer customer, Item item, LocalDate date) throws ItemNotAvailableException {
		assert item != null : "Item is Null" ;
		if (!item.isAvailable()) {
			throw new ItemNotAvailableException("Item ist nicht verfügbar");
		}
		item.setLending(new Lending(customer, item, date));
		item.setState(State.LENT);
		return true;
	}

	public boolean addLending(Lending lending)  throws ItemNotAvailableException {
		Item item = lending.getItem();
		if (!item.isAvailable()) {
			throw new ItemNotAvailableException("Item ist nicht verfügbar");
		}
		lendings[this.lendingCounter++] = lending;
		item.setLending(lending);
		item.setState(State.LENT);
		return true;
	}

	public boolean returnItem(Item item, LocalDate date) {
		// Todo
		assert item != null : "Item is Null";
	
		item.setState(State.AVAILABLE);
		item.getLending().setReturnDate(date);
		return true;
	}

	public boolean isAvailable(Item item) {
		assert item != null : "Item is Null";
		return item.isAvailable();
	}

	public long[] getAvailableItems(long[] ids) throws NoAvailableItemsException {
		long[] result = null;
		// Todo
		for (long id : ids) {
			Item item;
			try {
				item = Administration.getInstance().findItem(id);
				if (item.isAvailable())
					result = Utils.addNumber(result, item.getId());
			} catch (NoItemsFoundException e) {
				System.out.println("Item not found");
			}
			if(result == null) {
				throw new NoAvailableItemsException("Keine Verfügbaen items gefunden");
			}
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
