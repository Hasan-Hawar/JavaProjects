import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Excute {

	public static void main(String[] args) {
		ExecutorService excutor = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++) {
			Runnable GreetingThreadPool = new GreetingThreadPool("Hello - " + (i + 1));
			excutor.execute(GreetingThreadPool);
		}
		excutor.shutdown();
		do {

		} while (!excutor.isTerminated());
		System.out.println("Thread Pool is finished");

	}
}
