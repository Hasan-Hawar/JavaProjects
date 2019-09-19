package Library.admin;

import java.time.LocalDate;

import Library.data.Actor;
import Library.data.Book;
import Library.data.BookItem;
import Library.data.Customer;
import Library.data.DataObject;
import Library.data.Film;
import Library.data.FilmItem;
import Library.data.Item;
import Library.data.JournalItem;
import Library.data.Music;
import Library.data.MusicItem;
import Library.data.Writer;

public class Administration {

	private LendingManager lendingManager;
	private DataManager dataManager;
	private static Administration instance;

	private Administration() {
		this.lendingManager = new LendingManager();
		this.dataManager = new DataManager();
	}

	public static Administration getInstance() {
		if (instance == null) {
			instance = new Administration();
		}
		return instance;
	}

	public DataObject[] getDataObject() {
		return dataManager.getDataObjects();
	}

	public BookItem[] getBookItem() {
		return dataManager.getBookItem();
	}

	public FilmItem[] getFilmItem() {
		return dataManager.getFilmItem();
	}

	public MusicItem[] getMusicItem() {
		return dataManager.getMusicItem();
	}

	public JournalItem[] getJournalItem() {
		return dataManager.getJournalItem();
	}

	public long[] findBookItem(Writer writer) {
		return this.dataManager.findBookItems(writer);
	}

	public long[] findMusicItem(String title) {
		return dataManager.findMusicItems(title);
	}

	public DataObject findDataObject(String title) {
		return dataManager.findDataObject(title);
	}

	public long[] findItems(String title) {
		return this.dataManager.findItems(title);
	}

	public long[] findFilmItem(Actor actor) {
		return this.dataManager.findFilmItems(actor);
	}

	/*
	 * public Film findFilm(Actor actor, long n) { return
	 * dataManager.findFilm(actor); }
	 */
	public boolean isItemAvailable(Item item) {
		return this.lendingManager.isItemAvailable(item);
	}

	public LocalDate getLendingEndDate(Item item) {
		return this.lendingManager.getLendingEndDate(item);
	}

	public void addLending(Customer customer, Item item, LocalDate startDate) {
		this.lendingManager.addLending(customer, item, startDate);
	}

	public void returnItem(Item item, LocalDate date) {
		this.lendingManager.returnItem(item, date);
	}

}
