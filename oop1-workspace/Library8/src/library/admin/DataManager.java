package library.admin;

import library.data.Book;
import library.data.Actor;
import library.data.BookItem;
import library.data.Customer;
import library.data.Film;
import library.data.FilmItem;
import library.data.Item;
import library.data.Journal;
import library.data.JournalItem;
import library.data.Music;
import library.data.MusicItem;
import library.data.Writer;
import library.admin.Utils;

public class DataManager {
	private Customer[] customers;
	private BookItem[] bookItems;
	private FilmItem[] filmItems;
	private MusicItem[] musicItems;
	private JournalItem[] journalItems;

	public DataManager() {
		customers = new Customer[20];
		bookItems = new BookItem[30];
		filmItems = new FilmItem[30];
		musicItems = new MusicItem[30];
		journalItems = new JournalItem[30];
	}

	public long[] findItemsByArticleNumber(long ean) {
		long[] result = null;
		// Todo
		for (BookItem item : bookItems) {
			if (item.getBook().getArticleNumber() == ean)
				result = Utils.addNumber(result, item.getId());

		}
		for (MusicItem item : musicItems) {
			if (item.getMusic().getArticleNumber() == ean)
				result = Utils.addNumber(result, item.getId());

		}
		for (JournalItem item : journalItems) {
			if (item.getJournal().getArticleNumber() == ean) {
				result = Utils.addNumber(result, item.getId());
			}
		}
		for (FilmItem item : filmItems) {
			if (item.getFilm().getArticleNumber() == ean)
				result = Utils.addNumber(result, item.getId());

		}
		return result;
		/*
		 * Item[] result = Utils.findMethod(bookItems, musicItems, journalItems,
		 * filmItems); ArrayList<Long> eanItems = new ArrayList<>(); for (Item item :
		 * result) { if (item.getDataObject().getArticleNumber() == ean) {
		 * eanItems.add(item.getId()); } } return Utils.toArrayList(eanItems);
		 */

	}

	public long[] findItems(String s) {
		long[] result = null;
		result = Utils.addNumbers(result, findBookItems(s));
		result = Utils.addNumbers(result, findMusicItems(s));
		result = Utils.addNumbers(result, findFilmItems(s));
		result = Utils.addNumbers(result, findJournalItems(s));
		return result;
	}

	public Item findItem(long id) {
		// Todo
		for (Item item : bookItems) {
			if (item.getId() == id)
				return item;

		}
		for (Item item : musicItems) {
			if (item.getId() == id)
				return item;

		}
		for (Item item : journalItems) {
			if (item.getId() == id)
				return item;

		}
		for (Item item : filmItems) {
			if (item.getId() == id)
				return item;

		}
		return null;
	}

	public <T> long[] findItems(Class<T> type, String string) {
		// Todo
		if (type.equals(Book.class)) {
			return findBookItems(string);
		}
		if (type.equals(Music.class)) {
			return findMusicItems(string);
		}
		if (type.equals(Film.class)) {
			return findFilmItems(string);
		}
		if (type.equals(Journal.class)) {
			return findJournalItems(string);
		}
		return null;

	}

	public long[] findItems(String title, Actor actor) {
		long[] result = null;
		// Todo
		for (FilmItem item : filmItems) {
			if (item.getFilm().getTitle().equals(title)) {
				for (Actor a : item.getFilm().getActors()) {
					if (a != null && a.equals(actor))
						result = Utils.addNumber(result, item.getId());
				}
			}
		}
		return result;
	}

	public long[] findItems(Writer writer) {
		long[] result = null;
		// Todo
		for (BookItem item : bookItems) {
			Book book = item.getBook();
			if (book.getWriter().equals(writer)) {
				result = Utils.addNumber(result, item.getId());
			}
		}
		return result;
	}

	public long[] findItems(Actor actor) {
		long[] result = null;
		// Todo
		for (FilmItem item : filmItems) {
			Film film = item.getFilm();
			Actor[] actors = film.getActors();
			if (contains(actors, actor)) {
				result = Utils.addNumber(result, item.getId());
			}
		}
		return result;
	}

	private long[] findBookItems(String title) {
		long[] result = null;
		// Todo
		for (BookItem item : bookItems) {
			// Book book = item.getBook();
			if (item.getBook().getTitle().equals(title)) {
				result = Utils.addNumber(result, item.getId());
			}

		}
		return result;
	}

	private long[] findMusicItems(String s) {
		long[] result = null;
		// Todo
		for (MusicItem item : this.musicItems) {
			// Music music = item.getMusic();
			if (item.getMusic().getTitle().equals(s)) {
				result = Utils.addNumber(result, item.getId());
			}
			if (item.getMusic().getBand().equals(s)) {
				result = Utils.addNumber(result, item.getId());
			}
		}
		return result;
	}

	private long[] findFilmItems(String s) {
		long[] result = null;
		// Todo
		for (FilmItem item : filmItems) {
			if (item.getFilm().getTitle().equals(s)) {
				result = Utils.addNumber(result, item.getId());
			}
			if (item.getFilm().getPublisher().equals(s)) {
				result = Utils.addNumber(result, item.getId());
			}
		}
		return result;
		/*
		 * ArrayList<Long> itemList = new ArrayList<>(); for (FilmItem film :
		 * this.filmItems) { if (film.getFilm().getTitle().equals(s)) {
		 * itemList.add(film.getId()); } if (film.getFilm().getPublisher().equals(s)) {
		 * itemList.add(film.getId()); } } return Utils.toArrayList(itemList);
		 */
	}

	private long[] findJournalItems(String s) {
		long[] result = null;
		// Todo
		for (JournalItem item : this.journalItems) {
			Journal journal = item.getJournal();
			if (journal.getTitle().equals(s)) {
				result = Utils.addNumber(result, item.getId());
			}
			if (journal.getPublisher().equals(s)) {
				result = Utils.addNumber(result, item.getId());
			}
		}
		return result;
	}

	private boolean contains(Actor[] actors, Actor actor) {
		for (Actor a : actors) {
			if (a != null && a.equals(actor))
				return true;
		}
		return false;
	}

	public void printItems() {
		for (BookItem e : bookItems) {
			System.out.println(e.toString());
		}
		for (MusicItem e : musicItems) {
			System.out.println(e.toString());
		}
		for (FilmItem e : filmItems) {
			System.out.println(e.toString());
		}
		for (JournalItem e : journalItems) {
			System.out.println(e.toString());
		}
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public BookItem[] getBookItems() {
		return bookItems;
	}

	public FilmItem[] getFilmItems() {
		return filmItems;
	}

	public MusicItem[] getMusicItems() {
		return musicItems;
	}

	public JournalItem[] getJournalItems() {
		return journalItems;
	}
}
