import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Excute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E  MMM dd yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
		executor.scheduleAtFixedRate(() -> {
			System.out.println(formattedDate + " -" + " Hello World. ");

		}, 10, 3, TimeUnit.SECONDS);
		executor.schedule(() -> {
			System.out.println(" Ends");
		}, 24, TimeUnit.SECONDS);

		executor.schedule(() -> {
			executor.shutdownNow();
		}, 24, TimeUnit.SECONDS);
		do {

		} while (!executor.isTerminated());
		System.out.println("All Threads are finished");

	}
}
