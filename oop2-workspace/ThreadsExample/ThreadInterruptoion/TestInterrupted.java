
public class TestInterrupted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread = new Thread(new printMyName("Hasan", 1000, 6));
		System.out.println("Starting ... ");
		thread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception

		}
		thread.interrupt();
	}

}
