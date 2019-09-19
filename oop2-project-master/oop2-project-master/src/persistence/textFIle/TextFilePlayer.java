package persistence.textFIle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logic.game.Player;
import persistence.PersistenceException;
import persistence.PlayerDAO;

public class TextFilePlayer extends PersistenceException implements PlayerDAO {

	private File file;

	public TextFilePlayer(File file) {
		// TODO Auto-generated constructr stub
		this.file = file;
	}

	@Override
	public void savePlayer(List<Player> players) throws PersistenceException {
		// PrintWriter out ;
		// players.add(player1);
		try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
			// File file = new File(path);
			// file.createNewFile();
			// out = new PrintWriter(neout = println()
			for (Player player : players) {
				out.println(player.toString());
			}
		} catch (FileNotFoundException e) {
			throw new PersistenceException("File does nit exist", e);
		} catch (IOException e) {
			// TODO: handle exception
			throw new PersistenceException("Uspecified Problem with IO", e);
		}
	}

	@Override
	public List<Player> loadPlayers() throws PersistenceException, TextFileParseException {
		ArrayList<Player> players = new ArrayList<>();
//		Scanner scan = null;
//		String line = null;
		try (Scanner in = new Scanner(new FileReader(file))) {
			// scan = new Scanner(new File(path), "UTF-8");
//			while (scan.hasNext()) {
//				line = scan.nextLine();
//				Player player = new Player(line);
//				players.add(player);
			parseFile(players, in);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			throw new PersistenceException(e);
		}
		return players;
	}

	private void parseFile(ArrayList<Player> players, Scanner in) throws TextFileParseException {
		int lineNb = 0;
		while (in.hasNext()) {
			String line = in.nextLine();
			lineNb++;
			if (!line.isEmpty()) {
				try {
					Player player = new Player(line);
					players.add(player);
				} catch (NullPointerException | IllegalArgumentException | DateTimeException e) {
					// TODO: handle exception
					throw new TextFileParseException(file.getAbsolutePath(), lineNb, line, e);
				}
			}
		}
	}

}
