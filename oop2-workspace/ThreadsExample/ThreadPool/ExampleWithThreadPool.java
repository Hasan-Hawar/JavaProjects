import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleWithThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 12; i++) {
			Runnable task = new Task(i);
			executor.execute(task);
		}
		executor.shutdown();

		do {

		} while (!executor.isTerminated());
		System.out.println("All thread are finished.");

	}

}
