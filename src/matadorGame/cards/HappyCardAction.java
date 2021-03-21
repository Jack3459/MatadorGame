package matadorGame.cards;

import matadorGame.player.Player;

public class HappyCardAction {

  public HappyCardAction() {
  }

  public void cardDrawn(int cardNumber, Player player, HappyCard happyCard) {

    switch (cardNumber) {

      case 1:
        card1(player);
        break;

      case 2:
        card2(player);
        break;

      case 3:
        card3(player);
        break;

      case 4:
        card4(player);
        break;

      case 5:
        card5(player, happyCard);
        break;

      case 6:
        //Something
        break;

      case 7:
        //Something
        break;

      case 8:
        //Something
        break;

      case 9:
        //Something
        break;

      case 10:
        //Something
        break;

      case 11:
        //Something
        break;

      case 12:
        //Something
        break;

      case 13:
        //Something
        break;

      case 14:
        //Something
        break;

      case 15:
        //Something
        break;

      case 16:
        //Something
        break;

      case 17:
        //Something
        break;

      case 18:
        //Something
        break;

      case 19:
        //Something
        break;

      case 20:
        //Something
        break;

      case 21:
        //Something
        break;

      case 22:
        //Something
        break;

      case 23:
        //Something
        break;

      case 24:
        //Something
        break;

      case 25:
        //Something
        break;

      case 26:
        //Something
        break;

      case 27:
        //Something
        break;

      case 28:
        //Something
        break;

      case 29:
        //Something
        break;

      case 30:
        //Something
        break;

      case 31:
        //Something
        break;

      case 32:
        //Something
        break;

      case 33:
        //Something
        break;

      case 34:
        //Something
        break;

      case 35:
        //Something
        break;

      case 36:
        //Something
        break;

      case 37:
        //Something
        break;

      case 38:
        //Something
        break;

      case 39:
        //Something
        break;

      case 40:
        //Something
        break;
      default:
        System.out.println("Not valid");
    }
  }

  private void card1(Player player) {
    // Move to Start. Deposit 4000.
    player.setPosition(0);
    player.depositMoney(4000);
  }

  private void card2(Player player) {
    // Move to Grenaa-Hundestad, if you pass start deposit 4000. (15)
    if (player.getPosition() > 15) {
      System.out.println("You pass start, deposit 4000");
      player.depositMoney(4000);
    }

    player.setPlayerMoved(true);
    player.setPosition(15);
  }

  private void card3(Player player) {
    // Move 3 rows forward.
    player.setPlayerMoved(true);
    player.setPosition(player.getPosition() + 3);
  }

  private void card4(Player player) {
    // Pay 3000 for reparation of van.
    player.withdrawMoney(3000);
  }

  private void card5(Player player, HappyCard happyCard) {
    // Get out of jail free card.
    player.addHappyCard(happyCard);
  }

}
