
import java.util.List;

public interface PlayerDAO {

	public void savePlayer(List<Player> players);
	// public void savePlayer();

	public List<Player> loadPlayers();
}
