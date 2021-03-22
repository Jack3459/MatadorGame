package matadorGame.fields;

import matadorGame.player.Player;

import java.util.Scanner;


public abstract class Ownable extends Field {

  public Scanner scanner = new Scanner(System.in);

  private boolean isOwned = false;
  private int rent;
  private String cardID;
  private int salePrice;
  private int collection;
  private Player owner;

  // Constructor
  public Ownable(String name, int number, int salePrice, String cardID) {
    super(name, number);
    this.salePrice = salePrice;
    this.cardID = cardID;
  }

  public Ownable(String name, int number, int salePrice, String cardID, int collection) {
    super(name, number);
    this.salePrice = salePrice;
    this.cardID = cardID;
    this.collection = collection;
  }


  // Getter
  public boolean getIsOwned() {
    return isOwned;
  }

  public int getCollection() { return collection; }

  public int getRent() {
    return rent;
  }

  public int getSalePrice() {
    return salePrice;
  }

  public Player getOwner() {
    return owner;
  }

  public String getCardID() { return cardID; }

  // Setter
  public void setIsOwned(boolean isOwned) { this.isOwned = isOwned; }

  public void setCollection(int collection) { this.collection = collection; }

  public void setOwner(Player owner) { this.owner = owner; }

  public void setRent(int rent) { this.rent = rent; }

  public void setCardID(String cardID) { this.cardID = cardID; }

  // Method
  @Override //Checks if field is owned, if its owned rent has to be paid, else they are promted if they want to buy
  public void landOnField(Player player) {
    System.out.println(player.getPlayerName() + " have landed on " + getName());
    if (getIsOwned()) {
      if (!getOwner().inPrison()) {
        if (getOwner() == player) {
          player.withdrawMoney(0);
        } else {
          payRent(player);
        }
      }
    } else {
      System.out.println("Do you want to buy " + getName() + "?\nSalesPrice is: " + getSalePrice());
      System.out.print("Type true or false: ");
      boolean yn = scanner.nextBoolean();
      buy(yn, player);
    }

  }

  private void payRent(Player player) {

    if (ownAllFieldsInCollection()) {
      player.withdrawMoney(rent() * 2);
      getOwner().depositMoney(rent() * 2);
    } else {
      player.withdrawMoney(rent());
      getOwner().depositMoney(rent());
    }

  }

  public boolean ownAllFieldsInCollection() {
    int count = 0;

    if (!cardID.equals("Ship") && !cardID.equals("Brew")) {
      for (int i = 0; i < getOwner().getCardsOwned().size(); i++) {
        if (getOwner().getCardsOwned().get(i).getCardID().equals(cardID)) {
          count++;
          if (count == getOwner().getCardsOwned().get(i).getCollection()) {
            return true;
          }
        }
      }
    }

    return false;
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
