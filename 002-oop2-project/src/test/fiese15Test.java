package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.game.Alpha;
import logic.game.EmptyStripe;
import logic.game.Player;

class fiese15Test {



  EmptyStripe emptyStripe = new EmptyStripe();

  int[] stripe2 = emptyStripe.getStripe();


  Player player1 = new Player("Max");


  @BeforeEach
  void setUp() throws Exception {}


  @Test
  void sum15Test() {

    for (int i = 0; i < 10; i++) {
      int sum = 0;
      Alpha alpha = new Alpha();

      int[] stripe = alpha.newStripe();
      for (int a : stripe) {
        System.out.print(a + " ");
      }
      for (int b = 0; b < stripe.length; b++) {
        sum += stripe[b];
      }
      System.out.print(" " + sum);
      System.out.println();
      assertEquals(sum, 15);
    }
  }

  @Test
  void validRandomNumber() {
    boolean check = false;
    for (int i = 0; i < stripe2.length; i++) {
      if (stripe2[i] > 0 && stripe2[i] < 7) {
        check = true;
      }
      assertTrue(check);
    }
  }


  @Test
  void addScore() {
    int currentScore = 21;
    player1.addScore(currentScore);
    assertEquals(21, player1.getScore());
  }


  @Test
  void secondRollDice() {
    boolean[] decisionStripe = {false, true, false, true, false, true};
    int [] testStripe = emptyStripe.rollDice(stripe2, decisionStripe);
    assertTrue(testStripe[0]!=0);
    assertTrue(testStripe[1]==0);
    assertTrue(testStripe[2]!=0);
    assertTrue(testStripe[3]==0);
    assertTrue(testStripe[4]!=0);
    assertTrue(testStripe[5]==0);
    }
  
  
  @Test
  void isRollable() {
    int [] testFinalStripe = {1,3,2,4,2,3};
    Alpha alpha = new Alpha();
   assertFalse(alpha.isRollable(testFinalStripe));
  }
  }

