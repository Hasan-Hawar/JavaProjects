import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static String path = "src/player.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player player1 = new Player("Hasan");
		// player1.toString();
		List<Player> pls = new ArrayList<>();
		pls.add(player1);
		savePlayer(pls);
		loadPlayer();
		System.out.println(pls);
	}

	public static void savePlayer(List<Player> players) {

		PrintWriter out = null;
		// players.add(player1);
		try {
			File file = new File(path);
			file.createNewFile();
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), Charset.forName("UTF-8")));
			for (Player player : players) {

				out.write(player.toString());
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}

	}

	public static List<Player> loadPlayer() {
		ArrayList<Player> players = new ArrayList<>();
		Scanner scan = null;
		String line = null;
		try {
			scan = new Scanner(new File(path), "UTF-8");
			while (scan.hasNext()) {
				line = scan.nextLine();
				Player player = new Player(line);
				players.add(player);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
		return players;
	}
}
