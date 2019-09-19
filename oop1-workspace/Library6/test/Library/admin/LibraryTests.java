
package Library.admin;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Library.admin.Administration;
import Library.data.Actor;
import Library.data.BookItem;
import Library.data.DataObject;
import Library.data.FilmItem;
import Library.data.JournalItem;
import Library.data.MusicItem;
import Library.data.Writer;

class LibraryTests {
	private Administration admin;
	private BookItem[] bookItems;
	private MusicItem[] musicItems;
	private FilmItem[] filmItems;
	private JournalItem[] journalItems;

	@BeforeEach
	private void setUp() {
		admin = TestSetUp.testSetUp();
		bookItems = admin.getBookItem();
		musicItems = admin.getMusicItem();
		filmItems = admin.getFilmItem();
		journalItems = admin.getJournalItem();
	}

	@Test
	void test01() {
		long[] found = admin.findBookItem(new Writer("Schreiber", "Peter"));
		Assertions.assertEquals(found[0], bookItems[2].getId());
	}

	@Test
	void test02() {
		long[] found = admin.findBookItem(new Writer("Schreiberin", "Anna"));
		Assertions.assertEquals(found[0], bookItems[4].getId());
	}

	@Test
	void test03() {
		long[] m = admin.findMusicItem("Abba");
		Assertions.assertEquals(m[0], musicItems[0].getId());
	}

	@Test
	void test04() {
		long[] m = admin.findMusicItem("Enja");
		Assertions.assertEquals(m[2], musicItems[8].getId());
	}

	@Test
	void test05() {
		long[] m = admin.findMusicItem("Pink Floyd");
		Assertions.assertEquals(m[1], musicItems[7].getId());
	}

	@Test
	void test06() {
		DataObject obj = admin.findDataObject("Nature");
		Assertions.assertEquals(obj, filmItems[2].getFilm());
	}
	
	@Test
	void test07() {
		Assertions.assertTrue(admin.isItemAvailable(bookItems[0]));
	}
	@Test
	void test08() {
		Assertions.assertTrue(admin.isItemAvailable(musicItems[0]));
	}
	@Test
	void test09() {
		Assertions.assertTrue(admin.isItemAvailable(filmItems[0]));
	}
	@Test
	void test10() {
		Assertions.assertTrue(admin.isItemAvailable(journalItems[0]));
	}
	@Test
	void test11() {
		Assertions.assertTrue(admin.isItemAvailable(bookItems[1]));
	}
	@Test
	void test12() {
		Assertions.assertTrue(admin.isItemAvailable(musicItems[4]));
	}
	@Test
	void test13() {
		Assertions.assertTrue(admin.isItemAvailable(filmItems[1]));
	}
	@Test
	void test14() {
		Assertions.assertTrue(admin.isItemAvailable(journalItems[7]));
	}
	@Test
	void test15() {
		DataObject obj = admin.findDataObject("LNCS");
		Assertions.assertEquals(obj, journalItems[2].getJournal());

	}

	@Test
	void test16() {
		assertEquals(admin.getLendingEndDate(musicItems[0]), LocalDate.now());
	}

	@Test
	void test17() {
		assertEquals(admin.getLendingEndDate(bookItems[0]), LocalDate.now());
	}

	@Test
	void test18() {
		assertEquals(admin.getLendingEndDate(filmItems[4]), LocalDate.now());
	}

	@Test
	void test19() {
		assertEquals(admin.getLendingEndDate(musicItems[10]), LocalDate.now());
	}

	@Test
	void test20() {
		long[] found = admin.findBookItem(new Writer("Schreiberin", "Barbara"));
		assertEquals(found[0], bookItems[0].getId());
		assertEquals(found[1], bookItems[7].getId());
	}

	@Test
	void test22() {
		long[] found = admin.findMusicItem("Abba");
		assertEquals(found[0], musicItems[0].getId());
		assertEquals(found[1], musicItems[6].getId());
	}

	@Test
	void test23() {
		long[] found = admin.findItems("LNCS");
		assertEquals(found[0], journalItems[2].getId());
		assertEquals(found[1], journalItems[8].getId());
	}

	@Test
	void test25() {
		long[] found = admin.findFilmItem(new Actor("Portman", "Natalie"));
		assertNotEquals(found[0], filmItems[2].getId());
		assertNotEquals(found[1], filmItems[5].getId());
	}
}
