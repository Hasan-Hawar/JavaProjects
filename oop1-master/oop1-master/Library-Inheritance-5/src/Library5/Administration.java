package Library5;
import java.time.LocalDate;

public class Administration {

	private DataObject[] dataObjects;
	private Lending[] lendings;
	private Reservation[] reservations;
	private Customer[] customers;

	public Administration() {
		dataObjects = new DataObject[20];
		lendings = new Lending[20];
		reservations = new Reservation[20];
		customers = new Customer[20];

	}

	public Lending[] getLendings() {
		return lendings;
	}

	public Reservation[] getReservations() {
		return reservations;
	}

	public DataObject[] getDataObjects() {
		return dataObjects;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void printObjects() {
		for (Object e : dataObjects) {
			System.out.println(e.toString());
		}
	}

	public void printLendings() {
		for (Lending l : lendings) {
			System.out.println(l.toString());
		}
	}

	public DataObject findDataObject(long ean) {
		for (DataObject o : dataObjects) {
			if (o.getArticleNumber() == ean) {
				return o;
			}
		}
		return null;
	}

	public DataObject findDataObject(String title) {
		for (DataObject o : dataObjects) {
			if (o.getTitle().equals(title)) {
				return o;
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

	public Lending getLastLend(Object object) {
		Lending lastLend = null;
		for (Lending lend : lendings) {
			if (object == lend.getDataObject()) {
				if (lastLend == null || lend.getStartDate().isAfter(lastLend.getStartDate())) {
					lastLend = lend;
				}
			}
		}
		return lastLend;
	}

	public boolean isObjectAvailable(DataObject dataObject) {
		for (int i = lendings.length - 1; i >= 0; i--) {
			if (lendings[i].getDataObject() instanceof DataObject) {
				DataObject obj = (DataObject) lendings[i].getDataObject();
				if (obj.equals(dataObject)) {
					return (lendings[i].getReturnDate() != null);
				}
			}
		}
		return true;
	}

	/*
	 * public boolean isObjectAvailable(DataObject obj) { for (Object o :
	 * this.lendings) { if (o instanceof DataObject) { if (((Lending)
	 * o).getDataObject() instanceof DataObject) { if (obj == ((Lending)
	 * o).getDataObject()) { return true; } } if
	 * ((getLastLend(o)).getDataObject().equals(obj)) { return true; } }
	 * 
	 * } return false; }
	 */
	public LocalDate getLendingEndDate(DataObject obj) {
		for (int i = lendings.length - 1; i >= 0; i--) {
			DataObject o = lendings[i].getDataObject();
			if (o.equals(obj)) {
				if (lendings[i].getReturnDate() != null)
					return lendings[i].getReturnDate();
				else
					return lendings[i].getTimeLimit();
			}
		}
		return LocalDate.now();
	}

	/*
	 * public boolean isBookAvailable(Book book) { for (int i = lendings.length - 1;
	 * i >= 0; i--) { if (lendings[i].getDataObject() instanceof Book) { Book obj =
	 * (Book) lendings[i].getDataObject(); if (obj.equals(book)) { return
	 * (lendings[i].getReturnDate() != null); } } } return true; }
	 * 
	 * public boolean isJournalAvailable(Journal journal) { for (int i =
	 * lendings.length - 1; i >= 0; i--) { if (lendings[i].getDataObject()
	 * instanceof Journal) { Journal obj = (Journal) lendings[i].getDataObject(); if
	 * (obj.equals(journal)) { return (lendings[i].getReturnDate() != null); } }
	 * 
	 * } return true; }
	 * 
	 * public boolean isFilmAvailable(Film film) {
	 * 
	 * for (int i = lendings.length - 1; i >= 0; i--) { if
	 * (lendings[i].getDataObject() instanceof Film) { Film obj = (Film)
	 * lendings[i].getDataObject(); if (obj.equals(film)) { return
	 * (lendings[i].getReturnDate() != null); } }
	 * 
	 * } return true; }
	 * 
	 * public boolean isMusicAvailable(Music music) { for (int i = lendings.length -
	 * 1; i >= 0; i--) { if (lendings[i].getDataObject() instanceof Music) { Music
	 * obj = (Music) lendings[i].getDataObject(); if (obj.equals(music)) { return
	 * (lendings[i].getReturnDate() != null); } }
	 * 
	 * } return true; }
	 */

}
