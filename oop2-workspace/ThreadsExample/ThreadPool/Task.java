
public class Task implements Runnable {

	private int id;

	public Task(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName().toUpperCase() + " :start Task " + id);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : end Task " + id);
	}

}
