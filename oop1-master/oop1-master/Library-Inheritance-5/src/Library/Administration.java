package Library;

import java.time.LocalDate;

public class Administration {

	private Object[] objects;
	private Lending[] lendings;
	private Reservation[] reservations;
	private Customer[] customers;

	public Administration() {
		objects = new Object[20];
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

	public Object[] getObjects() {
		return objects;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void printObjects() {
		for (Object e : objects) {
			System.out.println(e.toString());
		}
	}

	public void printLendings() {
		for (Lending l : lendings) {
			System.out.println(l.toString());
		}
	}

	public static Administration testSetUp() {
		Administration admin = new Administration();
		Object[] objects = admin.getObjects();

		int counter = 1;
		Writer[] w = new Writer[7];

		w[0] = new Writer("Schreiberin", "Barbara");
		w[1] = new Writer("Schreiber", "Hans");
		w[2] = new Writer("Schreiber", "Peter");
		w[3] = new Writer("Schreiber", "Willi");
		w[4] = new Writer("Schreiber", "Rolf");
		w[5] = new Writer("Schreiberin", "Anna");
		w[6] = new Writer("Schreiberin", "Marie");

		objects[0] = new Book(counter++, "On the Road", w[0], 530);
		objects[1] = new Book(counter++, "The last Day", w[1], 650);
		objects[2] = new Book(counter++, "Behind the Moon", w[2], 300);
		objects[3] = new Book(counter++, "The Day after", w[3], 620);
		objects[4] = new Book(counter++, "The Hour", w[4], 510);
		objects[5] = new Book(counter++, "Kings Field", w[5], 320);
		objects[6] = new Book(counter++, "Why", w[6], 170);

		objects[7] = new Music(counter++, "The Best Of", "Abba", 68);
		objects[8] = new Music(counter++, "The Best Of", "Pink Floyd", 72);

		objects[9] = new Film(counter++, "Star Wars", "Lucas Film", 145);
		objects[10] = new Film(counter++, "Star Wars", "Lucas Film", 145);

		objects[11] = new Journal(counter++, "Nature", "Springer", 108);
		objects[12] = new Journal(counter++, "GEO", "Gruner", 82);

		objects[13] = new Journal(counter++, "Science", " Al Hayat ", 330);

		Customer leser = new Customer("Leser", "Bruno", "bruno@leser.com");
		Customer seher = new Customer("Seher", "Kurt", "kurt@seher.com");
		Customer hoerer = new Customer("Hörer", "Emma", "emma@hoerer.com");

		admin.lendings[0] = new Lending(leser, objects[1], LocalDate.of(2018, 9, 4));
		admin.lendings[1] = new Lending(leser, objects[2], LocalDate.of(2018, 9, 21));
		admin.lendings[2] = new Lending(leser, objects[12], LocalDate.of(2018, 9, 25));
		admin.lendings[3] = new Lending(hoerer, objects[7], LocalDate.of(2018, 9, 23));
		admin.lendings[4] = new Lending(hoerer, objects[8], LocalDate.of(2018, 9, 30));
		admin.lendings[5] = new Lending(seher, objects[10], LocalDate.of(2018, 9, 24));
		admin.lendings[6] = new Lending(seher, objects[9], LocalDate.of(2018, 9, 1));
		admin.lendings[7] = new Lending(seher, objects[1], LocalDate.of(2018, 10, 12));

		admin.reservations[0] = new Reservation(leser, objects[12], LocalDate.of(2018, 10, 1));
		admin.reservations[1] = new Reservation(leser, objects[7], LocalDate.of(2018, 10, 2));
		return admin;
	}

	public Journal findJournal(long articleNumber) {
		for (Object journal : this.objects) {
			if (journal instanceof Journal) {
				if (articleNumber == ((Journal) journal).getArticleNumbr()) {
					// return Journal;
					return (Journal) journal;
				}
			}
		}
		return null;
	}

	public Journal findJournal(String title) {
		for (Object journal : this.objects) {
			if (journal instanceof Journal) {
				if (title == ((Journal) journal).getTitle()) {
					// return Journal;
					return (Journal) journal;
				}
			}
		}
		return null;
	}

	public Book findBook(String title) {
		for (Object book : this.objects) {
			if (book instanceof Book) {
				if (((Book) book).getTitle().equals(title)) {
					// return Book;
					return (Book) book;
				}
			}
		}
		return null;
	}

	public Book findBook(Writer writer) {
		for (Object book : this.objects) {
			if (book instanceof Book) {
				if (((Book) book).getWriter().equals(writer)) {
					// return Book;
					return (Book) book;
				}
			}
		}
		return null;
	}

	public Film findFilm(Actor actor) {
		for (Object film : this.objects) {
			if (film instanceof Film) {
				if (actor == ((Film) film).getActors()) {
					// return Film;
					return (Film) film;
				}
			}
		}
		return null;
	}

	public Film findFilm(String title) {
		for (Object film : this.objects) {
			if (film instanceof Film) {
				if (title == ((Film) film).getTitle()) {
					// return Film;
					return (Film) film;
				}
			}
		}
		return null;
	}

	public Music findMusic(String bandName) {
		for (Object music : this.objects) {
			if (music instanceof Music) {
				if (((Music) music).getBandName().equals(bandName)) {
					// return Music;
					return (Music) music;
				}
			}
		}
		return null;
	}

	public Lending getLastLend(Object object) {
		Lending lastLend = null;
		for (Lending lend : lendings) {
			if (object == lend.getObject()) {
				if (lastLend == null || lend.getStartDate().isAfter(lastLend.getStartDate())) {
					lastLend = lend;
				}
			}

		}
		return lastLend;
	}

	public boolean isBookAvailable(Book book) {
		for (Lending lending : this.lendings) {
			if (book instanceof Book) {
				if (lending.getObject().equals(book)) {
					if (lending.getReturnDate() == null) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/*
	 * public boolean isBookAvailable1(Book book) { for (Object book1 :
	 * this.lendings) { if (book1 instanceof Book) { if (((Lending)
	 * book1).getObject().equals(book)) { return true; } if
	 * ((getLastLend(book)).getReturnDate() != null) { return true; } } } return
	 * false; }
	 */
	public boolean isJournalAvailable(Journal journal) {
		for (Object journal1 : this.lendings) {
			if (journal instanceof Journal) {
				if (((Lending) journal1).getObject().equals(journal)) {
					return true;
				}
			}
			if ((getLastLend(journal)).getReturnDate() != null) {
				return true;
			}

		}
		return false;
	}

	public boolean isFilmAvailable(Film film) {
		for (Lending lending : this.lendings) {
			if (film instanceof Film) {
				if (lending.getObject().equals(film)) {
					if (lending.getReturnDate() == null) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/*
	 * public boolean isFilmAvailable(Film film) { for (Object film1 :
	 * this.lendings) { if (film instanceof Film) { if (((Lending)
	 * film1).getObject().equals(film)) { return true; } if
	 * ((getLastLend(film)).getReturnDate() != null) { return true; } }
	 * 
	 * } return false; }
	 */

	public boolean isMusicAvailable(Music music) {
		for (Lending lending : this.lendings) {
			if (music instanceof Music) {
				if (lending.getObject().equals(music)) {
					if (lending.getReturnDate() == null) {
						return false;
					}
				}
			}
		}
		return true;
	}
	/*
	 * public boolean isMusicAvailable(Music music) { for (Object music1 :
	 * this.lendings) { if (music instanceof Music) { if (((Lending)
	 * music1).getObject().equals(music)) { return true; } if
	 * ((getLastLend(music)).getReturnDate() != null) { return true; } }
	 * 
	 * } return false; }
	 */

	/*
	 * public LocalDate getLendingEndDate(Book book) { LocalDate lendingDate = null;
	 * for (Object lend : this.lendings) { // Lending lending = null; if (((Lending)
	 * lend).getObject().equals(book)) { lendingDate =
	 * (getLastLend(book).getStartDate().minusMonths(-1)); } else { lendingDate =
	 * LocalDate.now(); } } return lendingDate; }
	 */
	public LocalDate getLendingEndDate(Book book) {
		Lending Endlend = null;
		// LocalDate lendingDate = null;
		for (Lending lend : this.lendings) {

			if (lend.getObject().equals(book)
					&& (Endlend == null || lend.getStartDate().isAfter(Endlend.getStartDate()))) {
				Endlend = lend;
			}
		}
		if (Endlend != null) {
			if (Endlend.getReturnDate() != null) {
				return Endlend.getReturnDate();
			}

			return Endlend.getStartDate().minusMonths(-1);
		}
		return LocalDate.now();
	}

	/*
	 * public LocalDate getLendingEndDate(Journal journal) { LocalDate lendingDate =
	 * null; for (Object lend : this.lendings) { // Lending lending = null; if
	 * (((Lending) lend).getObject().equals(journal)) { lendingDate =
	 * (getLastLend(journal).getStartDate().minusMonths(-1)); } else lendingDate =
	 * LocalDate.now(); } return lendingDate; }
	 */

	public LocalDate getLendingEndDate(Journal journal) {
		Lending Endlend = null;
		// LocalDate lendingDate = null;
		for (Lending lend : this.lendings) {

			if (lend.getObject().equals(journal)
					&& (Endlend == null || lend.getStartDate().isAfter(Endlend.getStartDate()))) {
				Endlend = lend;
			}

			return Endlend.getStartDate().minusMonths(-1);
		}
		return LocalDate.now();
	}

	/*
	 * public LocalDate getLendingEndDate(Film film) { LocalDate lendingDate = null;
	 * for (Object lend : this.lendings) { // Lending lending = null; if (((Lending)
	 * lend).getObject().equals(film)) { lendingDate =
	 * (getLastLend(film).getStartDate().minusMonths(-1)); } else lendingDate =
	 * LocalDate.now(); } return lendingDate; }
	 */

	public LocalDate getLendingEndDate(Film film) {
		Lending Endlend = null;
		// LocalDate lendingDate = null;
		for (Lending lend : this.lendings) {

			if (lend.getObject().equals(film)
					&& (Endlend == null || lend.getStartDate().isAfter(Endlend.getStartDate()))) {
				Endlend = lend;
			}
		}
		if (Endlend != null) {
			if (Endlend.getReturnDate() != null) {
				return Endlend.getReturnDate();
			}
			return Endlend.getStartDate().minusMonths(-1);
		}
		return LocalDate.now();
	}
	/*
	 * public LocalDate getLendingEndDate(Music music) { LocalDate lendingDate =
	 * null; for (Object lend : this.lendings) { // Lending lending = null; if
	 * ((((Lending) lend).getObject()).equals(music)) { lendingDate =
	 * ((getLastLend(music)).getStartDate().minusMonths(-1)); } else lendingDate =
	 * LocalDate.now(); } return lendingDate; }
	 */

	public LocalDate getLendingEndDate(Music music) {
		Lending Endlend = null;
		// LocalDate lendingDate = null;
		for (Lending lend : this.lendings) {

			if (lend.getObject().equals(music)
					&& (Endlend == null || lend.getStartDate().isAfter(Endlend.getStartDate()))) {
				Endlend = lend;
			}
		}
		if (Endlend != null) {
			if (Endlend.getReturnDate() != null) {
				return Endlend.getReturnDate();
			}
			return Endlend.getStartDate().minusMonths(-1);
		}
		return LocalDate.now();
	}

}
