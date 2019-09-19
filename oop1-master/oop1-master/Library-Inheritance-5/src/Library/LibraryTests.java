package Library;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTests {
	private Administration admin;
	private Object[] objects;
	private Lending[] lendings;

	@BeforeEach
	private void setUp() {
		admin = TestSetUp.testSetUp();
		objects = admin.getObjects();
		lendings = admin.getLendings();
	}

//------------Test 4-----------------------Exercises 4---------------------

	@Test
	void testfindJournal() {
		Journal obj = (Journal) admin.findJournal(17);
		assertEquals(obj, objects[16]);
	}

	@Test
	void testfindBook() {
		Book obj = (Book) admin.findBook("Behind the Moon");
		assertEquals(obj, objects[2]);

	}

	@Test
	void testfindMusic() {
		Music obj = (Music) admin.findMusic("Abba");
		assertEquals(obj, objects[7]);
	}

	@Test
	void testFindJournal() {
		Journal obj = (Journal) admin.findJournal("Nature");
		assertEquals(obj, objects[11]);
	}

	@Test
	void testFindFilm() {
		Film obj = (Film) admin.findFilm("Star Wars I");
		assertEquals(obj, objects[9]);
	}

	@Test
	void testfindBook2() {
		Book obj = ((Book) admin.findBook(new Writer("Schreiberin", "Barbara")));
		assertEquals(obj, objects[0]);
	}

	@Test
	void testFindFilm2() {
		
		  Film obj = admin.findFilm(new Actor("Portman", "Natalie")); 
		  assertNotEquals(obj, objects[9]);
		 
	//	assertEquals((Film) admin.findFilm(new Actor("Portman", "Natalie")), objects[9]);
	}

	// IsAvailable Test------------------------

	@Test
	void testIsBookAvailable1() {
		assertFalse(admin.isBookAvailable((Book) objects[1]));
	}

	@Test
	void testIsBookAvailable2() {
		assertFalse(admin.isBookAvailable((Book) objects[2]));
	}

	@Test
	void testIsBookAvailable3() {
		assertTrue(admin.isBookAvailable((Book) objects[3]));
	}

	@Test
	void testIsMusicAvailable1() {
		assertFalse(admin.isMusicAvailable((Music) objects[7]));
	}

	@Test
	void testIsMusicAvailable2() {
		assertFalse(admin.isMusicAvailable((Music) objects[8]));
	}

	@Test
	void testIsFilmAvailable1() {
		assertFalse(admin.isFilmAvailable((Film) objects[9]));
	}

	@Test
	void testIsFilmAvailable2() {
		assertFalse(admin.isFilmAvailable((Film) objects[10]));
	}

	@Test
	void testIsJournalAvailable1() {
		assertTrue(admin.isJournalAvailable((Journal) objects[11]));
	}

	void testIsJournalAvailable2() {
		assertFalse(admin.isJournalAvailable((Journal) objects[12]));
	}

	// getLendingEndDate Test---------------------

	@Test
	void testLendingEndDateBook1() {
		assertEquals(admin.getLendingEndDate((Book) objects[0]), LocalDate.now());
	}

	@Test
	void testtLendingEndDateBook2() {
		assertEquals(admin.getLendingEndDate((Book) objects[1]), LocalDate.of(2018,11,1));
	}

	@Test
	void testLendingEndDateMusic() {
		assertEquals(admin.getLendingEndDate((Music) objects[7]), LocalDate.of(2018, 10, 23));
	}

	@Test
	void testLendingEndDateFilm() {
		assertEquals(admin.getLendingEndDate((Film) objects[10]), LocalDate.of(2018, 10, 24));
	}

	// ------------------------------------------
	@Test
	void test01() {
		Assertions.assertNotEquals(new Book(1, "", new Writer("", ""), 0), new Book(1, "", new Writer("", ""), 0));
	}

	@Test
	void test05() {
		Book obj = (Book) objects[0];
		assertTrue(admin.isBookAvailable(obj));
	}

	@Test
	void test06() {
		Book obj = (Book) objects[1];
		assertFalse(admin.isBookAvailable(obj));
	}

	@Test
	void test15() {
		Book obj = (Book) objects[0];
		assertEquals(admin.getLendingEndDate(obj), LocalDate.now());
	}
	
	// ImmutableTest -------------------
	
	@Test
	void testImmutableBook () {
		assertNotEquals(new Book(1, "", new Writer("", ""),0), new Book(1, "", new Writer("", ""), 0));
	}
	
	@Test
	void testImmutabelJournal () {
		assertNotEquals(new Journal(0, "", "", 1), new Journal(0, "", "", 1));
	}
	
	/*@Test
	void testImmutableFilm() {
		assertNotEquals(new Film(1, "", "", 1), new Film(1, "", "", 1));
	}*/
	
	/*@Test
	void testImmutableMusic() {
		assertNotEquals(new Music(1, "", "", 1),new Music(1, "", "", 1));
	}*/

	/*@Test
	void test25() {
		Film obj = (Film) admin.findFilm(new Actor("Portman", "Natalie"));
		Assertions.assertEquals(obj, objects[9]);
	}*/

	/*
	 * @Test void testBook() { assertEquals(((Book)
	 * admin.getObjects()[0]).getTitle(), "On the Road"); assertEquals(((Book)
	 * admin.getObjects()[0]).getWriter().getlastName(), "Barbara");
	 * assertEquals(((Book) admin.getObjects()[0]).getPages(), 530);
	 * 
	 * assertEquals(((Book) admin.getObjects()[1]).getTitle(), "The last Day");
	 * assertEquals(((Book) admin.getObjects()[1]).getWriter().getlastName(),
	 * "Hans"); ; assertEquals(((Book) admin.getObjects()[1]).getPages(), 650);
	 * 
	 * assertEquals(((Book) admin.getObjects()[2]).getTitle(), "Behind the Moon");
	 * assertEquals(((Book) admin.getObjects()[2]).getWriter().getlastName(),
	 * "Peter"); assertEquals(((Book) admin.getObjects()[2]).getPages(), 300);
	 * 
	 * assertEquals(((Book) admin.getObjects()[3]).getTitle(), "The Day after");
	 * assertEquals(((Book) admin.getObjects()[3]).getWriter().getlastName(),
	 * "Willi"); assertEquals(((Book) admin.getObjects()[3]).getPages(), 620);
	 * 
	 * assertEquals(((Book) admin.getObjects()[4]).getTitle(), "The Hour");
	 * assertEquals(((Book) admin.getObjects()[4]).getWriter().getlastName(),
	 * "Rolf"); assertEquals(((Book) admin.getObjects()[4]).getPages(), 510);
	 * 
	 * assertEquals(((Book) admin.getObjects()[5]).getTitle(), "Kings Field");
	 * assertEquals(((Book) admin.getObjects()[5]).getWriter().getlastName(),
	 * "Anna"); assertEquals(((Book) admin.getObjects()[5]).getPages(), 320);
	 * 
	 * assertEquals(((Book) admin.getObjects()[6]).getTitle(), "Why");
	 * assertEquals(((Book) admin.getObjects()[6]).getWriter().getlastName(),
	 * "Marie"); assertEquals(((Book) admin.getObjects()[6]).getPages(), 170);
	 * 
	 * }
	 * 
	 * @Test void testMusic() { assertEquals(((Music)
	 * admin.getObjects()[7]).getTitle(), "The Best Of"); assertEquals(((Music)
	 * admin.getObjects()[7]).getBandName(), "Abba"); assertEquals(((Music)
	 * admin.getObjects()[7]).getLength(), 68);
	 * 
	 * assertEquals(((Music) admin.getObjects()[8]).getTitle(), "The Best Of");
	 * assertEquals(((Music) admin.getObjects()[8]).getBandName(), "Pink Floyd");
	 * assertEquals(((Music) admin.getObjects()[8]).getLength(), 72);
	 * 
	 * }
	 * 
	 * @Test void testFilm() { assertEquals(((Film)
	 * admin.getObjects()[9]).getTitle(), "Lucas Film"); assertEquals(((Film)
	 * admin.getObjects()[9]).getActors(), "Star Wars"); assertEquals(((Film)
	 * admin.getObjects()[9]).getLength(), 145); }
	 * 
	 * @Test void testJournal() { assertEquals(((Journal)
	 * admin.getObjects()[11]).getTitle(), "Nature"); assertEquals(((Journal)
	 * admin.getObjects()[11]).getPublisher(), "Springer"); assertEquals(((Journal)
	 * admin.getObjects()[11]).getPages(), 108);
	 * 
	 * assertEquals(((Journal) admin.getObjects()[12]).getTitle(), "GEO");
	 * assertEquals(((Journal) admin.getObjects()[12]).getPublisher(), "Gruner");
	 * assertEquals(((Journal) admin.getObjects()[12]).getPages(), 82); }
	 * 
	 * @Test void testLending() {
	 * assertEquals(admin.getLendings()[0].getCustomer().getfirstName(), "Leser");
	 * assertEquals(admin.getLendings()[1].getCustomer().getlastName(), "Bruno");
	 * assertTrue(admin.getLendings()[2].getStartDate().isBefore(LocalDate.now()));
	 * 
	 * assertEquals(admin.getLendings()[3].getCustomer().getfirstName(), "Hörer");
	 * 
	 * 
	 * assertEquals(admin.getLendings()[5].getCustomer().getfirstName(), "Seher");
	 * assertEquals(admin.getLendings()[6].getCustomer().getlastName(), "Kurt");
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * void testReservation() {
	 * assertTrue(admin.getReservations()[0].getLocalDate().isBefore(LocalDate.now()
	 * ));
	 * 
	 * }
	 * 
	 * // =================================Tests 3================================
	 * 
	 * @Test void testBook1() {
	 * 
	 * assertNotNull(((Book) admin.getObjects()[0]).getTitle());
	 * assertNotEquals(((Book) admin.getObjects()[0]).getTitle(), ""); }
	 * 
	 * @Test void testJournal2() { assertTrue(((Journal)
	 * admin.getObjects()[11]).getPages() > 100); }
	 * 
	 * @Test void testMusic3() { assertEquals(((Music)
	 * admin.getObjects()[7]).getBandName(), "Abba"); }
	 * 
	 * @Test void testJournal4() { assertEquals(((Journal)
	 * admin.getObjects()[12]).getPublisher(), "Gruner"); }
	 * 
	 * @Test void testLending5() { assertEquals(((Lending)
	 * admin.getLendings()[5]).getCustomer().getfirstName(), "Seher"); }
	 * 
	 * @Test void testWriter6() { assertEquals(((Book)
	 * admin.getObjects()[1]).getWriter().getlastName(), "Hans"); }
	 * 
	 * @Test void testLending7() {
	 * assertTrue(admin.getLendings()[3].getStartDate().isBefore(LocalDate.now()));
	 * }
	 * 
	 * @Test void testResarvation8() {
	 * assertTrue(admin.getReservations()[0].getLocalDate().isBefore(LocalDate.now()
	 * )); }
	 * 
	 * @Test void test1() { assertNotNull(admin.getObjects()[0]); }
	 */

}
