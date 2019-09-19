
public class LamdaThreading1 {

	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(2000);
				System.out.println("Hello Threading ..");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("Starting ... ");
		thread.start();
	}
}
