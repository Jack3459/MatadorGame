package matadorGame.fields;

import matadorGame.player.Player;

public class HappyCardField extends Field {

  public HappyCardField(String name, int number) {
    super(name, number);
  }

  @Override
  public void landOnField(Player player) {

    player.setIsOnHappyCard(true);
    System.out.println("Landed on happy card");

  }

  @Override
  public String toString() {
    return null;
  }
}
