package Library5;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LibraryTests {
	private Administration admin;
	private DataObject[] Dataobjects;
	private Lending[] lendings;

	@BeforeEach
	private void setUp() {
		admin = TestSetUp.testSetUp();
		Dataobjects = admin.getDataObjects();
		lendings = admin.getLendings();
	}

//------------Test 4-----------------------Exercises 4---------------------

	@Test
	void testfindJournal() {
		Journal obj = (Journal) admin.findDataObject(17);
		assertEquals(obj, Dataobjects[16]);
	}

	@Test
	void testfindBook() {
		Book obj = (Book) admin.findDataObject("Behind the Moon");
		assertEquals(obj, Dataobjects[2]);

	}

	@Test
	void testfindMusic() {
		Music obj = (Music) admin.findMusic("Abba");
		assertEquals(obj, Dataobjects[7]);
	}

	@Test
	void testFindJournal() {
	
		assertEquals((Journal) admin.findDataObject("Nature"), Dataobjects[11]);
	}

	@Test
	void testFindFilm() {
		Film obj = (Film) admin.findDataObject("Star Wars I");
		assertEquals(obj, Dataobjects[9]);
	}

	@Test
	void testfindBook2() {
		Book obj = ((Book) admin.findBook(new Writer("Schreiberin", "Barbara")));
		assertEquals(obj, Dataobjects[0]);
	}

	@Test
	void testFindFilm2() {

		Film obj = admin.findFilm(new Actor("Portman", "Natalie"));
		assertEquals(obj, Dataobjects[9]);

		assertEquals((Film) admin.findFilm(new Actor("Portman", "Natalie")), Dataobjects[9]);
	}

	// getLendingEndDate Test---------------------

	@Test
	void testLendingEndDateBook1() {
		assertEquals(admin.getLendingEndDate((Book) Dataobjects[0]), LocalDate.now());
	}

	@Test
	void testtLendingEndDateBook2() {
		assertEquals(admin.getLendingEndDate((Book) Dataobjects[1]), LocalDate.of(2018, 11, 1));
	}

	@Test
	void testLendingEndDateMusic() {
		assertEquals(admin.getLendingEndDate((Music) Dataobjects[7]), LocalDate.of(2018, 10, 23));
	}

	@Test
	void testLendingEndDateFilm() {
		assertEquals(admin.getLendingEndDate((Film) Dataobjects[10]), LocalDate.of(2018, 10, 24));
	}

	// ------------------------------------------
	/*
	 * @Test void test01() { Assertions.assertNotEquals(new Book(1, "", new
	 * Writer("", ""), 0), new Book(1, "", new Writer("", ""), 0)); }
	 */
	@Test
	void test05() {
		Book obj = (Book) Dataobjects[0];
		assertTrue(admin.isObjectAvailable(obj));
	}

	@Test
	void test06() {
		Book obj = (Book) Dataobjects[1];
		assertFalse(admin.isObjectAvailable(obj));
	}

	@Test
	void test15() {
		Book obj = (Book) Dataobjects[0];
		assertEquals(admin.getLendingEndDate(obj), LocalDate.now());
	}

	// ImmutableTest -------------------

	@Test
	void testImmutableBook() {
		assertNotEquals(new Book(1, "", new Writer("", ""), 1), new Book(1, "", new Writer("", ""), 1));
	}

	@Test
	void testImmutabelJournal() {
		assertNotEquals(new Journal(0, "", "", 1), new Journal(0, "", "", 1));
	}

	@Test
	void testImmutableFilm() {
		assertNotEquals(new Film(1, "", "", 1), new Film(1, "", "", 1));
	}

	@Test
	void testImmutableMusic() {
		assertNotEquals(new Music(0, "", "", 1), new Music(0, "", "", 1));
	}

	@Test
	void test25() {
		Film obj = (Film) admin.findFilm(new Actor("Portman", "Natalie"));
		assertEquals(obj, Dataobjects[9]);
	}

// Test Exercise 5 ----------Find--Objects--------------------------------------------------

	@Test
	void testFindDataObjectBook() {
		assertEquals(admin.findDataObject("On the Road"), Dataobjects[0]);
	}

	@Test
	void testFindDataObjectMusic() {
		assertEquals(admin.findDataObject("The Best Of"), Dataobjects[7]);
	}

	@Test
	void testFindDataObjectFilm() {
		assertEquals(admin.findDataObject("Star Wars I"), Dataobjects[9]);
	}

	@Test
	void testFindDataObjectJournal() {
		assertEquals(admin.findDataObject("GEO"), Dataobjects[12]);
	}

	@Test
	void testFindDataObjet_ByEAN_Book() {
		assertEquals(admin.findDataObject(2), Dataobjects[1]);
	}

	@Test
	void testFindDataObjet_ByEAN_Music() {
		assertEquals(admin.findDataObject(9), Dataobjects[8]);
	}

	@Test
	void testFindDataObjet_ByEAN_Film() {
		assertEquals(admin.findDataObject(11), Dataobjects[10]);
	}

	@Test
	void testFindDataObjet_ByEAN_Journal() {
		assertEquals(admin.findDataObject(14), Dataobjects[13]);
	}

//getLending Test -----------
	@Test
	void testGetLendingEndDate_1() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[9]), LocalDate.of(2018, 10, 24));
	}

	@Test
	void testGetLendingEndDate_2() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[5]), LocalDate.now());
	}

	@Test
	void testGetLendingEndDate_3() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[16]), LocalDate.of(2018, 11, 6));
	}
	@Test
	void testGetLendingEndDate_4() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[3]), LocalDate.of(2018, 9, 25));
	}
	
	@Test
	void testGetLendingEndDate_5() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[4]), LocalDate.now());
	}
	@Test
	void testGetLendingEndDate_6() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[7]), LocalDate.of(2018, 10, 23));
	}
	@Test
	void testGetLendingEndDate_7() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[1]), LocalDate.of(2018, 11, 1));
	}
	@Test
	void testGetLendingEndDate_8() {
		assertEquals(admin.getLendingEndDate((DataObject) Dataobjects[6]), LocalDate.now());
	}
	
	
//--------InsztanceOf----Class-------Test-----------------------------------
	@Test
	void testInstancrOf_BookOfPrintMedium() {
		assertTrue(((Book) admin.getDataObjects()[6] instanceof PrintMedium));
	}

	@Test
	void testInstanceOf_BookOfPrintMedium() {
		assertTrue(Dataobjects[0] instanceof PrintMedium);
	}

	@Test
	void testInstanceOf_JournalOfPintMedium() {
		assertTrue(((Journal) admin.getDataObjects()[11] instanceof PrintMedium));
	}

	@Test
	void testInstanceOf_JournalOfPrintMedium() {
		assertTrue(Dataobjects[13] instanceof PrintMedium);
	}

	@Test
	void testInstanceOf_MusicOfDataObject() {
		assertTrue(((Music) admin.getDataObjects()[7] instanceof DataObject));
	}

	@Test
	void testInstanceOf_MusicOfDataObject_1() {
		assertTrue(Dataobjects[8] instanceof DataObject);
	}

	@Test
	void testInstanceOf_FilmOfDataObject() {
		assertTrue(((Film) admin.getDataObjects()[9] instanceof DataObject));
	}

	@Test
	void testInstanceOf_FilmOfDataObject_1() {
		assertTrue(Dataobjects[10] instanceof DataObject);
	}

	@Test
	void testInstanceOf_WriterOfPerson() {
		assertTrue(((Book) admin.getDataObjects()[5]).getWriter() instanceof Person);
	}

	@Test
	void testInstanceOf_ActorOfPerson() {
		assertTrue(Film.getActors()[1] instanceof Person);
	}

	@Test
	void testInstanceOf_CustomerOfPerson() {
		assertTrue(new Customer("Leser", "Bruno", "bruno@leser.com") instanceof Person);
	}

	@Test
	void testInstanceOf_CustomerOfPerson_1() {
		assertTrue(new Customer("Seher", "Kurt", "kurt@seher.com") instanceof Person);
	}

	// IsAvailable Test------------------------

	@Test
	void testIsBookAvailable_1() {
		assertFalse(admin.isObjectAvailable((Book) Dataobjects[1]));
	}

	@Test
	void testIsBookAvailable_2() {
		assertFalse(admin.isObjectAvailable((Book) Dataobjects[2]));
	}

	@Test
	void testIsBookAvailable_3() {
		assertTrue(admin.isObjectAvailable((Book) Dataobjects[3]));
	}

	@Test
	void testIsBookAvailable_4() {
		assertTrue(admin.isObjectAvailable((Book) Dataobjects[4]));
	}

	@Test
	void testIsBookAvailable_5() {
		assertTrue(admin.isObjectAvailable((Book) Dataobjects[5]));
	}

	@Test
	void testIsBookAvailable_6() {
		assertTrue(admin.isObjectAvailable((Book) Dataobjects[6]));
	}

	@Test
	void testIsMusicAvailable_1() {
		assertFalse(admin.isObjectAvailable((Music) Dataobjects[7]));
	}

	@Test
	void testIsMusicAvailable_2() {
		assertFalse(admin.isObjectAvailable((Music) Dataobjects[8]));
	}

	@Test
	void testIsFilmAvailable_1() {
		assertFalse(admin.isObjectAvailable((Film) Dataobjects[9]));
	}

	@Test
	void testIsFilmAvailable_2() {
		assertFalse(admin.isObjectAvailable((Film) Dataobjects[10]));
	}

	@Test
	void testIsJournalAvailable_1() {
		assertFalse(admin.isObjectAvailable((Journal) Dataobjects[11]));

	}

	void testIsJournalAvailable_2() {
		assertFalse(admin.isObjectAvailable((Journal) Dataobjects[12]));
	}

	void testIsJournalAvailable_3() {
		assertFalse(admin.isObjectAvailable((Journal) Dataobjects[14]));
	}

	void testIsJournalAvailable_4() {
		assertFalse(admin.isObjectAvailable((Journal) Dataobjects[15]));
	}

	// ImmutableTest -------------------

	@Test
	void testEquals_Book() {
		assertNotEquals(new Book(2, "", new Writer("", ""), 2), new Book(2, "", new Writer("", ""), 2));
	}

	@Test
	void testEquals_Journal() {
		assertNotEquals(new Journal(1, "", "", 3), new Journal(1, "", "", 3));
	}

	@Test
	void testEquals_Film() {
		assertNotEquals(new Film(5, "", "", 1), new Film(5, "", "", 1));
	}

	@Test
	void testEquals_Music() {
		assertNotEquals(new Music(0, "", "", 1), new Music(0, "", "", 1));
	}
}
