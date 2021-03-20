package matadorGame.fields;

import matadorGame.player.Player;

public class Brewery extends Ownable {

  // Constructor
  public Brewery(String name, int number, int salePrice) {
    super(name, number, salePrice);
  }
  private Player hitField;

  // Method

  @Override
  public void landOnField(Player player) {
    System.out.println(player.getPlayerName() + " have landed on " + getName());
    if (getIsOwned() == true) {
      if (getOwner() == player) {
        player.withdrawMoney(0);
      } else {
        hitField = player;
        player.withdrawMoney(rent());
        getOwner().depositMoney(rent());
      }
    } else {
      System.out.println("Do you want to buy: " + getName() + "?\nSalesPrice is: " + getSalePrice());
      System.out.print("Type true or false: ");
      boolean yn = scanner.nextBoolean();
      buy(yn, player);
    }
  }



  // Rent is calculated based on player dicerolls, and how many properties are owned
/*  public int rent(Player player) {

    int diceHit = player.getDiceCup().getDiceSum();
    int more = getOwner().getCountBrewery();


    return diceHit * 100 * more;
  }*/

  @Override
  public int rent() {

    int diceHit = hitField.getDiceCup().getDiceSum();
    int more = getOwner().getCountBrewery();


    return diceHit * 100 * more;
  }

  @Override
  public String toString() {
    return "====================\n" +
        getNumber() + ". " + getName() + "\n" +

        "Rent 1 card: " + "Dice eys" + "\n" +
        "Rent 2 cards: " + "Dice eys times 2"+ "\n" +


        "Sales price: " + getSalePrice() + "\n" +
        "====================\n"
        ;
  }

}
