import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PerformanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2;
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		ExecutorService excutor = Executors.newFixedThreadPool(num);
		long mesure = System.currentTimeMillis();
		for (int i = 0; i < num; ++i) {
			excutor.execute(new WorkerThread(list));
		}
		excutor.shutdown();
		while (!excutor.isTerminated())
			;
		System.out.println("Result of Synchronized List : " + (System.currentTimeMillis() - mesure) + " Ms");

		List<String> listConWr = new CopyOnWriteArrayList<String>();
		ExecutorService executorConWr = Executors.newFixedThreadPool(num);
		mesure = System.currentTimeMillis();
		for (int i = 0; i < num; ++i) {
			executorConWr.execute(new WorkerThread(listConWr));
		}

		executorConWr.shutdown();

		while (!executorConWr.isTerminated())
			;
		System.out.println("Result for Concurrent List : " + (System.currentTimeMillis() - mesure) + " Ms");
	}

}
