import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GreetingScheduledThreadPool implements Runnable {

	private String greeting;
	LocalDateTime myDateObj = LocalDateTime.now();
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm:ss");
	String formattedDate = myDateObj.format(myFormatObj);

	public GreetingScheduledThreadPool(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(formattedDate + " - " + greeting);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
