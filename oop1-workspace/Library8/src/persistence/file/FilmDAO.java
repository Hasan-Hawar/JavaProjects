package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Actor;
import library.data.Film;

public class FilmDAO {

	private File filmFile;
	private String delimiter;
	private Film[] films;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public FilmDAO(File filmFile, String delimiter) {
		this.filmFile = filmFile;
		this.delimiter = delimiter;
		loadFilms();
	}

	private void loadFilms() {
		films = new Film[15];
		log("load films");
		try (Scanner scanner = new Scanner(new FileReader(filmFile))) {
			int nr = 0;
			Actor[] a = createActors();
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				int ean = Integer.parseInt(tokens[0]);
				int length = Integer.parseInt(tokens[3]);
				Film film = new Film(ean, tokens[1], tokens[2], length);
				film.addActor(a[Integer.parseInt(tokens[4])], 0);
				film.addActor(a[Integer.parseInt(tokens[5])], 1);
				film.addActor(a[Integer.parseInt(tokens[6])], 2);
				films[nr++] = film;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Film Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Film Datei ist korrput");
		}
	}

	public Film[] getFilms() {
		if (films == null)
			loadFilms();
		return films;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}

	private Actor[] createActors() {
		Actor[] a = new Actor[10];
		a[0] = new Actor("Norton", "Edward");
		a[1] = new Actor("Bale", "Christian");
		a[2] = new Actor("Delon", "Alain");
		a[3] = new Actor("Fels", "Edward");
		a[4] = new Actor("Stein", "Christian");
		a[5] = new Actor("Waltz", "Christoph");
		a[6] = new Actor("Portman", "Natalie");
		a[7] = new Actor("Depp", "Johnny");
		a[8] = new Actor("Weiss", "Johnny");
		a[9] = new Actor("Black", "Edward");
		return a;
	}
}
