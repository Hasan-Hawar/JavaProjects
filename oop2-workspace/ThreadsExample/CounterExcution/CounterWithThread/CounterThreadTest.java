package CounterWithThread;

public class CounterThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rounds = 10000;
		Counter counter = new Counter();

		Thread thread = new Thread(() -> {
			for (int i = 0; i < rounds; i++) {
				counter.countUp();
			}
		});
		thread.start();
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < rounds; i++) {
				counter.countUp();
			}
		});
		thread1.start();

		do {

		} while (thread.isAlive() || thread1.isAlive());
		System.out.println("The Final value of Counter is : " + counter.getCounter());
	}

}
