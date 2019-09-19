package NameThreads;

public class PrintMyName implements Runnable {
	private String name; // Person's name
	private int delay; // Delay before printing
	private int n; // How many times we print the name

	public PrintMyName(String name, int delay, int n) {
		this.name = name;
		this.delay = delay;
		this.n = n;
	}

	@Override
	public void run() {
		for (int i = 0; i < this.n; i++) {
			try {
				Thread.sleep(this.delay);

				System.out.println("My name is " + this.name);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new PrintMyName("Anna", 1000, 6));
		Thread thread2 = new Thread(new PrintMyName("John", 1000, 4));
		System.out.println("Starting...");
		thread1.start();
		thread2.start();
	}
}
