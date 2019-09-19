package logic.game;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Player {

	private String name;
	private int score;

	public Player(String name) {
		this.name = name;
		score = 0;
	}

//	public Player(String line) {
//		String[] value = line.split(",?\\s");
//		name = value[0];
//		score = Integer.parseInt(value[1]);
//	}

//  public void rollDice() {
//    dice.rollDice();
//  }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void addScore(int currentScore) {
		this.score += currentScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && Objects.equals(score, other.score);
	}

	@Override
	public String toString() {
		return "Player name : " + name + " ," + " Score : " + score + ".\n";
	}

	public Collection<? extends Player> setList(List<Player> playerList) {

		for (Object o : playerList) {
			if (o instanceof Player) {
				for (int j = 0; j <= playerList.size(); j++) {
					playerList.add(new Player("Player " + j + 1));
				}
			}
		}
		return playerList;
	}

}
