package library.admin;

import java.time.LocalDate;

import library.data.Actor;
import library.data.BookItem;
import library.data.Customer;
import library.data.FilmItem;
import library.data.Item;
import library.data.JournalItem;
import library.data.MusicItem;
import library.data.Writer;

public class Administration {

	private DataManager dataManager;
	private LendingManager lendingManager;
	private static Administration instance;
	public static Administration getInstance() {
		if (instance == null) {
			instance = new Administration();
		}
		return instance;
	}

	private Administration() {
		dataManager = new DataManager();
		lendingManager = new LendingManager();
	}

	public Item findItem(long id) throws NoItemsFoundException {
		return dataManager.findItem(id);
	}

	public long[] findItemByArticleNumber(long ean) throws  NoItemsFoundException {
		return dataManager.findItemsByArticleNumber(ean);
	}

	public long[] findItems(String title) throws NoItemsFoundException {
		return dataManager.findItems(title);
	}

	public long[] findItems(Writer writer) throws NoItemsFoundException {
		return dataManager.findItems(writer);
	}

	public long[] findItems(Actor actor) throws NoItemsFoundException {
		return dataManager.findItems(actor);
	}

	public <T> long[] findItems(Class<T> type, String string) throws NoItemsFoundException  {
		return dataManager.findItems(type, string);
	}

	public boolean isAvailable(Item item) {
		return lendingManager.isAvailable(item);
	}
	public void addLending(Customer customer, Item item, LocalDate date) throws ItemNotAvailableException {
		lendingManager.addLending(customer, item, date);
	}

	public DataManager getDataManager() {
		return dataManager;
	}

	public long[] getAvailableItems(long[] ids) throws NoAvailableItemsException {
		return lendingManager.getAvailableItems(ids);
	}

	public LocalDate getLendingEndDate(Item item) {
		return lendingManager.getLendingEndDate(item);
	}

	public LocalDate getTimeLimit(Item item) {
		return lendingManager.getTimeLimit(item);
	}

	
	public void returnItem(Item item, LocalDate date) throws ItemNotAvailableException {
		lendingManager.returnItem(item, date);
	}

	public BookItem[] getBookItems() {
		return dataManager.getBookItems();
	}

	public FilmItem[] getFilmItems() {
		return dataManager.getFilmItems();
	}

	public MusicItem[] getMusicItems() {
		return dataManager.getMusicItems();
	}

	public JournalItem[] getJournalItems() {
		return dataManager.getJournalItems();
	}

	public Customer[] setCustomers(Customer[] customers) {
		// TODO Auto-generated method stub
		return  customers;
		
		
	}

	public LendingManager getLendingManager() {
		// TODO Auto-generated method stub
		return lendingManager;
	}

	public Customer[] getCustomers() {
		return dataManager.getCustomers();
	}
	

}
