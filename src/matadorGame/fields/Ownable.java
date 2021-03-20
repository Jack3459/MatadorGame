package matadorGame.fields;

import matadorGame.player.Player;

import java.util.Scanner;


public abstract class Ownable extends Field {

  public Scanner scanner = new Scanner(System.in);

  private boolean isOwned = false;
  private int rent;
  private int salePrice;
  private Player owner;

  // Constructor
  public Ownable(String name, int number, int salePrice) {
    super(name, number);
    this.salePrice = salePrice;
  }

  // Getter
  public boolean getIsOwned() {
    return isOwned;
  }

  public int getRent() {
    return rent;
  }

  public int getSalePrice() {
    return salePrice;
  }

  public Player getOwner() {
    return owner;
  }

  // Setter
  public void setIsOwned(boolean isOwned) {
    this.isOwned = isOwned;
  }

  public void setOwner(Player owner) {
    this.owner = owner;
  }

  public void setRent(int rent) {
    this.rent = rent;
  }


  // Method
  @Override //Checks if field is owned, if its owned rent has to be paid, else they are promted if they want to buy
  public void landOnField(Player player) {
    System.out.println(player.getPlayerName() + " have landed on " + getName());
    if (getIsOwned() == true) {
      if (getOwner() == player) {
        player.withdrawMoney(0);
      } else {
        player.withdrawMoney(rent());
        getOwner().depositMoney(rent());
      }
    } else {
      System.out.println("Do you want to buy " + getName() + "?\nSalesPrice is: " + getSalePrice());
      System.out.print("Type true or false: ");
      boolean yn = scanner.nextBoolean();
      buy(yn, player);
    }
  }

  public abstract int rent();

  // Buy method, sets property as owned with player as owner and deducts amount from player,
  // adds property to player arraylist of properties owned
  public void buy(boolean wantToBuy, Player player) {
    if (wantToBuy == true) {
      player.withdrawMoney(getSalePrice());
      player.addCards(this);
      setOwner(player);
      setIsOwned(true);
    }

  }

  @Override
  public abstract String toString();


}
