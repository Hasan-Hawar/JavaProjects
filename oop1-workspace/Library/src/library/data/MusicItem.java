package library.data;

public class MusicItem extends Item {
	private Music music;

	public MusicItem(long id, Music music) {
		super(id);
		this.music = music;
	}

	public Music getMusic() {
		return music;
	}

	@Override
	public String toString() {
		return "Music: " + music + super.toString();
	}

	@Override
	public DataObject getDataObject() {
		// TODO Auto-generated method stub
		return getMusic();
	}
}
