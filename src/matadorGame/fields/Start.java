package matadorGame.fields;

import matadorGame.player.Player;

public class Start extends Field {


  public Start(String name, int number) {
    super(name, number);
  }

  @Override
  public void landOnField(Player player) {
    System.out.println("Your are on the start field");
  }

  @Override
  public String toString() {
    return null;
  }
}
