
public class printMyName implements Runnable {

	String name;
	int delay;
	int n;

	public printMyName(String name, int delay, int n) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.delay = delay;
		this.n = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.n; i++) {
			try {
				if (!Thread.interrupted()) {
					Thread.sleep(this.delay);
					System.out.println("My name is : " + name);
				} else {
					System.out.println("Loop was interrupted");
					break;
				}
			} catch (InterruptedException e) {
				// TODO: handle exception
				//
				e.printStackTrace();
				System.err.println("Interrupted in the sleep statement.");
			}
		}

	}
}
