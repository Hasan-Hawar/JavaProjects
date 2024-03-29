
public class ThreadsCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rounds = 1002000;
		Counter count = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < rounds; i++) {
				count.countUp();
			}
		});
		t1.start();

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < rounds; i++) {
				count.countUp();
			}
		});
		t2.start();

		do {

		} while (t1.isAlive() || t2.isAlive());
		System.out.println("the final value of the counter in two threads is : " + count.getCount());
	}

}
