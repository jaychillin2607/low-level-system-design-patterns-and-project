package models;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
  int diceCount;

  public Dice() {
    this(1);
  }

  public Dice(int diceCount) {
    if (diceCount > 3) {
      System.out.println("Dice count can't be greater than 3, defaulting to 3!!");
      this.diceCount = 3;
    } else {
      this.diceCount = diceCount;
    }
  }

  public int rollDice() {
    int sum = 0, count = 0;
    while (count < diceCount) {
      // System.out.print("Rolling Dice:");
      int val = ThreadLocalRandom.current().nextInt(1, 7);
      sum += val;
      count++;
      // System.out.printf(" %d%s", val, count == diceCount ? "" : ",");
    }
    return sum;
  }
}
