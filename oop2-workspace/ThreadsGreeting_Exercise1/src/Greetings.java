import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Greetings implements Runnable {

	private String language;
	private int delay;
	private int n;
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm:ss");
	String formattedDate = myDateObj.format(myFormatObj);

	public Greetings(String language, int delay, int n) {
		// TODO Auto-generated constructor stub

		this.language = language;
		this.delay = delay;
		this.n = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.n; i++) {
			try {
				Thread.sleep(this.delay);
				System.out.println((i + 1) + " - " + formattedDate + " " + this.language);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
	}

}
