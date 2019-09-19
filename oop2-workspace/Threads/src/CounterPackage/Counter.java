package CounterPackage;

public class Counter {
  /** Object state. */
  private long count = 0;

  /** Mutator method. */
  public void countUp() {
    count++;
  }

  /** Accessor method. */
  public long getCount() {
    return count;
  }
}
