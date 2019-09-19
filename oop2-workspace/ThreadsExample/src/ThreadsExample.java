
public class ThreadsExample implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable thread = new ThreadsExample();
		Thread thread2Example = new Thread(thread);
		System.out.println("Starting ...");
		thread2Example.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
			System.out.println("Hello Threadings");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
