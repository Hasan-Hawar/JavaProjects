
public class Excute_it {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread1 = new Thread(new Greetings("مرحبا", 1000, 4));
		Thread thread2 = new Thread(new Greetings("Hello", 1000, 4));
		Thread thread3 = new Thread(new Greetings("Guten Tag", 1000, 4));
		System.out.println("Starting ...");
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
