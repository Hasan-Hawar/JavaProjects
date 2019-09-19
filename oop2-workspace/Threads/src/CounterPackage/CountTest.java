package CounterPackage;

public class CountTest {

  public static void main(String[] args) {
    Counter counter = new Counter();
    int rounds = 1000;

    for (int i = 0; i < rounds; i++) {
      counter.countUp();
    }

    System.out.println("Final value of the counter: " + counter.getCount());
  }
}

