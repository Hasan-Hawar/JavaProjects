import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService excutor = Executors.newScheduledThreadPool(1);
		excutor.scheduleAtFixedRate(() -> {
			System.out.println("start new task");
		}, 1, 5, TimeUnit.SECONDS);
		excutor.schedule(() -> {
			System.out.println("Hello Scheduled Pool");
		}, 2, TimeUnit.SECONDS);
		excutor.schedule(() -> {
			excutor.shutdown();
		}, 15, TimeUnit.SECONDS);

		do {

		} while (!excutor.isTerminated());
		System.out.println("All threads are finished");

	}

}
