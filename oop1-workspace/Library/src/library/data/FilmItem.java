package library.data;

public class FilmItem extends Item {
	private Film film;

	public FilmItem(long id, Film film) {
		super(id);
		this.film = film;
	}

	public Film getFilm() {
		return film;
	}

	@Override
	public String toString() {
		return "Film: " + film + super.toString();
	}

	@Override
	public DataObject getDataObject() {
		// TODO Auto-generated method stub
		return getFilm();
	}
}
