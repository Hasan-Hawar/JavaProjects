package persistence;

import java.util.List;

import logic.game.Player;
import persistence.textFIle.TextFileParseException;;

public interface PlayerDAO {

	public void savePlayer(List<Player> players) throws PersistenceException;
	// public void savePlayer();

	public List<Player> loadPlayers() throws TextFileParseException, PersistenceException;
}
