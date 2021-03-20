package matadorGame.fields;

import matadorGame.player.Player;

public class Prison extends Field{

  // Constructor
  public Prison(String name, int number) {
    super(name, number);
  }

  // Method
  @Override
  public void landOnField(Player player) {
    System.out.println(player.getPlayerName() + " have landed on " + getName());

    player.setInPrison(true); // in prison
    player.setPosition(10); // move player to prison field 11 (index 10)

  }

  @Override
  public String toString() {
    return null;
  }


}
