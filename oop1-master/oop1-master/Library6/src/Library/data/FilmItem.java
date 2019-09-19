package Library.data;

public class FilmItem extends Item {

	private Film film;

	public FilmItem(long id, Film film) {
		super(id,film);
		this.film = (Film) this.getDataObject();
	}

	public Film getFilm() {
		return film;
	}
	@Override
	public String toString() {
		return "FilmItem [film:" + film + ", Id:" + getId() + ", isAvailable:" + isAvailable()
				+ ",Lending:" + getLending() + "]";
	}

}
