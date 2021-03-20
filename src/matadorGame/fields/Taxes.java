package matadorGame.fields;

import matadorGame.player.Player;

public class Taxes extends Field {

  private int tax = 0;
  // Constructor
  public Taxes(String name, int number) {
    super(name, number);
  }


  // Method
  @Override
  public void landOnField(Player player) {
    System.out.println(player.getPlayerName() + " have landed on " + getName());
    if (getName().equals("StateTax")) {
      if (player.getMoney() < 40000) {
        tax = player.getMoney() / 10;
      } else {
        tax = 4000;
      }

    } else if (getName().equals("Tax")) {
      tax = 2000;
    }

    player.withdrawMoney(tax);

  }

  @Override
  public String toString() {
    return "Tax on this filed: " + tax;
  }
}
