package matadorGame.player.dice;

import java.util.Random;

public class Dice {

  private final Random random = new Random();

  private int dice;

  // Constructor
  public Dice() {}

  // Getter
  public int getDice(){
    return dice;
  }

  // Setter
  public void setDice(){

    this.dice = random.nextInt(6) + 1;
  }

  public void setDiceCheat(int dice){

    this.dice = dice;
  }
}
