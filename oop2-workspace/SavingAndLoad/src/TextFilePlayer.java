
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilePlayer {

	private String path;
	private Player player;

	public TextFilePlayer(String path) {
		// TODO Auto-generated constructr stub
		this.path = path;
	}

	public void savePlayer(List<Player> players) {
		// public void savePlayer() {
		// TODO Auto-generated method stub
//		PrintWriter out = null;

//		String line = "Player Name : " + twoController.firstPlayer.getText().toString() + " Score: "
//				+ card.scoreField.textProperty().getValue() + " .";
// (BufferedWriter bw = new BufferedWriter(new FileWriter("src/player.txt")))
		PrintWriter out;
		Player player1 = new Player("hasan");
		List<Player> pls = new ArrayList<>();
		pls.add(player1);
		try {
			out = new PrintWriter(path);
			BufferedWriter bufferedWriter = new BufferedWriter(out);
			for (Player player : pls) {

				bufferedWriter.write(player.toString());
			}
			// bw.close();
//			bufferedWriter.write(line);
			bufferedWriter.flush();
			bufferedWriter.close();
			// out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path)));
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path)));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} // finally {
//			if (out != null) {
//				out.close();
//			}
//		}

	}

	public List<Player> loadPlayers() {
		// TODO Auto-generated method stub
		ArrayList<Player> players = new ArrayList<>();
		Scanner scan = null;
		String line;

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
