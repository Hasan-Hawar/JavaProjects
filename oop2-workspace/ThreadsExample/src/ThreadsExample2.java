
public class ThreadsExample2 {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
					System.out.println("Hello Threading .. ");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		Thread thread = new Thread(runnable);
		System.out.println("Starting...");
		thread.start();
	}

}
