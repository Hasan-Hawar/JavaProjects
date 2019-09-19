package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Music;

public class MusicDAO {
	private File musicFile;
	private String delimiter;
	private Music[] musics;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public MusicDAO(File musicFile, String delimiter) {
		this.musicFile = musicFile;
		this.delimiter = delimiter;
		loadMusics();
	}

	private void loadMusics() {
		musics = new Music[15];
		log("load musics");
		try (Scanner scanner = new Scanner(new FileReader(musicFile))) {
			int nr = 0;
			while (scanner.hasNextLine()) {
				String[] tokens = scanner.nextLine().split(delimiter);
				int ean = Integer.parseInt(tokens[0]);
				int length = Integer.parseInt(tokens[3]);
				Music music = new Music(ean, tokens[1], tokens[2], length);
				musics[nr++] = music;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Music Datei nicht gefunden");
		} catch (NumberFormatException e) {
			System.out.println("Music Datei ist korrput");
		}
	}

	public Music[] getMusics() {
		if (musics == null) 
			loadMusics();
		return musics;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
}
