package Library.admin;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Library.data.Customer;
import Library.data.Item;
import Library.data.Item.State;
import Library.data.Lending;

public class LendingManager {
	// private Lending[] lendings;

	private ArrayList<Lending> lendingArray;

	public LendingManager() {
		this.lendingArray = new ArrayList<Lending>();

	}

	public void printLendings() {
		for (Lending l : lendingArray) {
			System.out.println(l.toString());
		}
	}

	public Lending[] getLending() {
		return (Lending[]) lendingArray.toArray();
	}

	public boolean isItemAvailable(Item item) {
		boolean lendItem = false;
		// Lending lend1 = null;
		for (Lending lend : lendingArray) {
			if (item == lend.getItem()) {
				lendItem = true;
				if (lend.getItem().isAvailable()) {
					return true;
				}
			}
		}
		if (!lendItem) {
			return true;
		}
		return false;
	}
	/*
	 * for (int i = lendings.length - 1; i >= 0; i--) { if (lendings[i].getItem()
	 * instanceof Item) { Item obj = (Item) lendings[i].getItem(); if
	 * (obj.equals(item)) { return (lendings[i].getReturnDate() != null); } } }
	 * return true;
	 */

	public boolean addLending(Customer customer, Item item, LocalDate startDate) {
		// ArrayList<Lending> lending = new ArrayList<Lending>();
		if (item.isAvailable()) {
			lendingArray.add(new Lending(customer, item, startDate));
		} else if (!item.isAvailable()) {
			return false;
		}
		return true;
	}

	public LocalDate getLendingEndDate(Item item) {
		for (Lending lend : this.lendingArray) {
			if (lend.getItem().equals(item) && lend.getReturnDate() != null) {
				return lend.getReturnDate();
			}
			if (lend.getItem().equals(item) && lend.getReturnDate() == null) {
				return lend.getTimeLimit();
			}
		}
		return LocalDate.now();
	}

	/*
	 * public Lending getLastLend(Object object) { Lending lastLend = null; for
	 * (Lending lend : lendingArray) { if (lend.getItem().equals(object)) { if
	 * (lastLend == null || lend.getStartDate().isAfter(lastLend.getStartDate())) {
	 * lastLend = lend; } } } return lastLend; }
	 */
	public boolean returnItem(Item item, LocalDate date) {
		for (Lending lending : lendingArray) {
			if (lending.getItem().equals(item)) {
				if (lending.getStartDate().equals(date)) {
					lending.getItem().setState(State.AVAILABLE);
					lending.setReturnDate(date);
					return true;
				}
			}
		}
		return false;
	}

}
