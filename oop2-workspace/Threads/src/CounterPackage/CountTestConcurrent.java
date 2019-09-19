package CounterPackage;

public class CountTestConcurrent {

	public static void main(String[] args) {
		int rounds = 1000;
		Counter counter = new Counter();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < rounds; i++)
				counter.countUp();
		});
		thread1.start();
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < rounds; i++)
				counter.countUp();
		});
		thread2.start();
		do { // nothing
		} while (thread1.isAlive() || thread2.isAlive());
		System.out.println("Final value of the counter: " + counter.getCount());
	}
}
