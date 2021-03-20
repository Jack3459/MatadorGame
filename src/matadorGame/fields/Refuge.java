package matadorGame.fields;

import matadorGame.player.Player;

public class Refuge extends Field {

  private int bonus = 4000;

  // Constructor
  public Refuge(String name, int number) {
    super(name, number);
  }


  // Method
  @Override // The player gets a bonus deposited, when landing on field
  public void landOnField(Player player) {
    System.out.println(player.getPlayerName() + " have landed on " + getName());
    player.depositMoney(bonus);

  }
  public String toString() {
    return "Bonus on this field: " + bonus;
  }

}
