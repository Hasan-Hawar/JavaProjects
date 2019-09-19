import java.util.Date;

public class GreetingThreadPool implements Runnable {

	private String greeting;
	private static final int REPEATE = 1;
	private static final int DELAY = 1000;
//	LocalDateTime myDateObj = LocalDateTime.now();
//	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy HH:mm:ss");
//	String formattedDate = myDateObj.format(myFormatObj);

	public GreetingThreadPool(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			for (int i = 0; i <= REPEATE; i++) {
				Date now = new Date();
				System.out.println(now + " " + greeting);
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
