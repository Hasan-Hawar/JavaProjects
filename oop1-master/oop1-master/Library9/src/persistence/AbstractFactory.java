package persistence;

public interface AbstractFactory {

	ICustomerDAO createCustomerDAO();

	IBookDAO createBookDAO();

	IMusicDAO createMusicDAO();

	IFilmDAO createFilmDAO();

	IJournalDAO createJournalDAO();

	ILendingDAO createLendingDAO();

}