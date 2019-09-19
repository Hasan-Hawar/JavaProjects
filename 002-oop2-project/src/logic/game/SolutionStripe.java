package logic.game;

public class SolutionStripe {

  int count = 6;
  int sum = 15;
  int stripe[] = new int[count];


  public SolutionStripe() {

 
    java.util.Random g = new java.util.Random();


    sum -= count;

    for (int i = 0; i < count - 1; ++i) {
      stripe[i] = g.nextInt(sum);
    }
    stripe[count - 1] = sum;

    java.util.Arrays.sort(stripe);
    for (int i = count - 1; i > 0; --i) {
      stripe[i] -= stripe[i - 1];
    }

    for (int i = 0; i < count; ++i) {
      ++stripe[i];
    }

  }

  public int[] getStripe() {
    return stripe;
  }

  public void setStripe(int[] stripe) {
    this.stripe = stripe;
  }

}
