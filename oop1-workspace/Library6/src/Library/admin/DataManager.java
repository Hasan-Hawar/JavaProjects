package Library.admin;

import java.util.ArrayList;

import java.util.Collection;
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

public class DataManager {

	private DataObject[] dataObjects;
	private Collection<Customer> customer;
	private BookItem[] bookItem;
	private FilmItem[] filmItem;
	private MusicItem[] musicItem;
	private JournalItem[] journalItem;

	public DataManager() {
		this.dataObjects = new DataObject[44];
		this.customer = new ArrayList<>();
		this.bookItem = new BookItem[14];
		this.musicItem = new MusicItem[12];
		this.filmItem = new FilmItem[6];
		this.journalItem = new JournalItem[12];
	}

	public Customer[] getCustomers() {
		return (Customer[]) this.customer.toArray();
	}

	public BookItem[] getBookItem() {
		return this.bookItem;
	}

	public FilmItem[] getFilmItem() {
		return this.filmItem;
	}

	public MusicItem[] getMusicItem() {
		return this.musicItem;
	}

	public JournalItem[] getJournalItem() {
		return this.journalItem;
	}

	public DataObject findDataObject(long ean) {
		for (DataObject o : dataObjects) {
			if (o instanceof DataObject) {
				if (o.getArticleNumber() == ean) {
					return o;
				}
			}
		}
		return null;
	}

	public DataObject findDataObject(String title) {
		for (DataObject o : dataObjects) {
			if (o instanceof DataObject) {
				if (o.getTitle().equals(title)) {
					return o;
				}
			}
		}
		return null;
	}

	public long[] findItems(String title) {
		ArrayList<Long> list = new ArrayList<>();
		// Item [] itemsArray;
		Item[] itemsArray = findMethod(bookItem, filmItem, musicItem, journalItem);
		for (Item item : itemsArray) {
			if (item.getDataObject().getTitle().equals(title)) {
				list.add(item.getId());
			}
		}
		return LongToArray(list);
	}

	public long[] findBookItems(Writer writer) {
		ArrayList<Long> bookList = new ArrayList<>();
		for (BookItem book : this.bookItem) {
			if (book.getBook().getWriter().equals(writer)) {
				bookList.add(book.getId());
			}
		}
		return LongToArray(bookList);
	}

	public long[] findFilmItems(Actor actor) {
		ArrayList<Long> filmList = new ArrayList<>();
		for (FilmItem film : this.filmItem) {
			// Actor[] actors = film.getFilm().getActors();
			for (Actor a : film.getFilm().getActors()) {
				if (a.equals(actor)) {
					filmList.add(film.getId());
				}
			}
		}

		return LongToArray(filmList);
	}

	public long[] findMusicItems(String bandName) {
		ArrayList<Long> musicList = new ArrayList<>();
		for (MusicItem music : this.musicItem) {
			if (music.getMusic().getBandName().equals(bandName)) {
				musicList.add(music.getId());
			}
		}
		return LongToArray(musicList);
	}

	public Item isDataObjectAvailable(DataObject obj) {
		Item[] itemsArray = findMethod(bookItem, filmItem, musicItem, journalItem);
		for (Item item : itemsArray) {
			if (item.getDataObject().equals(obj)) {
				return item;
			}

		}
		return null;
	}

	public Book findBook(Writer writer) {
		for (DataObject o : dataObjects) {
			if (o instanceof Book) {
				Book b = (Book) o;
				if (b.getWriter().equals(writer))
					return b;
				Book obj = (Book) o;
				if (obj.getWriter().equals(writer))
					return obj;
			}
		}
		return null;
	}

	public Film findFilm(Actor actor) {
		for (DataObject o : dataObjects) {
			if (o instanceof Film) {
				Film obj = (Film) o;
				for (Actor a : obj.getActors()) {
					if (a.equals(actor))
						return obj;
				}
			}
		}
		return null;
	}

	public Music findMusic(String bandName) {
		for (DataObject o : dataObjects) {
			if (o instanceof Music) {
				Music m = (Music) o;
				if (m.getBandName().equals(bandName))
					return m;
			}
		}
		return null;
	}

	public void printObjects() {
		for (Object e : dataObjects) {
			System.out.println(e.toString());
		}
	}

	public DataObject[] getDataObjects() {
		return dataObjects;
	}

	public static Item[] findMethod(Item[]... arrays) {
		int n = 0;
		for (Item[] array : arrays) {
			n += array.length;
		}
		Item[] lastArray = new Item[n];
		int i = 0;
		for (Item[] array : arrays) {
			for (Item element : array) {
				lastArray[i] = element;
				i++;
			}
		}
		return lastArray;
	}

	public long[] LongToArray(ArrayList<Long> list) {
		long[] ItemId = new long[list.size()];
		int n = 0;
		for (Long item : list) {
			ItemId[n] = item;
			n++;
		}
		return ItemId;
	}

}
