package logic.game;

import java.util.Random;

public class EmptyStripe {

  int[] stripe = new int[6];
  boolean[] decisionStripe = {false, false, false, false, false, false};
  Random randomGenerator = new Random();

  public EmptyStripe() {

    for (int i = 0; i < stripe.length; i++) {
      stripe[i] = randomGenerator.nextInt(6) + 1;
    }
  }

  public int[] getStripe() {
    return stripe;
  }

  public void setStripe(int[] stripe) {
    this.stripe = stripe;
  }

  public boolean[] getDecisionStripe() {
    return decisionStripe;
  }

  public int[] rollDice(int[] stripe, boolean[] decisionStripe) {
    this.stripe = stripe;
    this.decisionStripe = decisionStripe;
    for (int i = 0; i < stripe.length; i++) {
      if (decisionStripe[i] == false) {
        stripe[i] = randomGenerator.nextInt(6) + 1;
      } else {
        stripe[i] = 0;
      }
    }
    return stripe;
  }
}
