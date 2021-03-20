package matadorGame.player.dice;

import matadorGame.player.Player;

public class DiceCup {

  private boolean diceCup = false;
  private Dice diceOne = new Dice();
  private Dice diceTwo = new Dice();

  private int[] diceHit = new int[11];
  private int[] diceSame = new int[6];

  private int rolls;

  // Constructor
  public DiceCup() {
  }

  public DiceCup(int rolls) {
    setRolls(rolls);
  }

  // Getter
  public int[] getDiceHit() {
    return diceHit;
  }

  public int getRolls() {
    return rolls;
  }

  public int[] getDiceSame() {
    return diceSame;
  }

  public int getDiceSum() { return diceOne.getDice() + diceTwo.getDice(); }

  public Dice getDiceOne() { return diceOne; }
  public Dice getDiceTwo() { return diceTwo; }

  // Setter
  public void setDiceCup(boolean state) {
    this.diceCup = state;
  }

  public void setRolls(int rolls) {
    this.rolls = rolls;
  }

  // Method
  public void diceRolls() {
    if (diceCup == true) {
      for (int i = 0; i < getRolls(); i++) {
        diceOne.setDice();
        int diceOne = this.diceOne.getDice();
        diceTwo.setDice();
        int diceTwo = this.diceTwo.getDice();

        getDiceHit()[diceOne + diceTwo - 2]++;

        if (diceOne == diceTwo) {
          getDiceSame()[diceOne - 1]++;
        }
      }
    } else{
      noDiceCup();
    }
  }

  public void noDiceCup() {
    System.out.println("You need the dice cup before rolling the dices.");
  }

  public void printingHitValues() {
    if(diceCup == true) {
      System.out.println("The result after " + rolls + " rolls: ");
      for (int i = 0; i < getDiceHit().length; i++) {
        System.out.println("The sum " + (i + 2) + " was rolled: " + getDiceHit()[i] + " times.");
      }
      System.out.println();
    }
  }

  public void printingSameValues(){
    if(diceCup == true) {
      System.out.println("The result after " + rolls + " rolls: ");
      for (int i = 0; i < getDiceSame().length; i++) {
        System.out.println("The pair of " + (i + 1) + " was rolled: " + getDiceSame()[i] + " times.");
      }
      System.out.println();
    }
  }

  public boolean isPair() {
    return diceOne.getDice() == diceTwo.getDice();
  }

  public void throwDice(Player player){
    diceOne.setDice();
    diceTwo.setDice();

    System.out.println(player.getPlayerName() + " rolled " + getDiceSum());
  }



}
