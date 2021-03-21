package matadorGame.player;

import matadorGame.cards.HappyCard;
import matadorGame.fields.Brewery;
import matadorGame.fields.Ownable;
import matadorGame.fields.Shipping;
import matadorGame.player.dice.DiceCup;

import java.util.ArrayList;

public class Player {
  private final DiceCup diceCup = new DiceCup(); //Change to 1 if only a single throw is wanted.
  private String playerName;
  private ArrayList<Ownable> cardsOwned = new ArrayList<Ownable>();
  private ArrayList<HappyCard> happyCardsOwned = new ArrayList<HappyCard>();

  private int money = 30000;
  private boolean inPrison;
  private int prisonCount;
  private int position = 0;
  private int pairsInRow = 0;

  private boolean isOnHappyCard;
  // We didn't make a bank-Class because we decided to start with a specific amount of money.
  // Therefore the bank isn't used.

  // Constructor
  public Player(String playerName) {

    setPlayerName(playerName);
  }

  // Getter
  public int getMoney() {
    return this.money;
  }

  public String getPlayerName() {
    return playerName;
  }

  public DiceCup getDiceCup() {
    return diceCup;
  }

  public boolean inPrison() {
    return inPrison;
  }

  public int getPrisonCount() {
    return prisonCount;
  }

  public int getPosition() { return position; }

  public int getPairsInRow() { return pairsInRow; }

  public boolean isOnHappyCard() { return isOnHappyCard; }

  // Setter
  public void setPlayerName(String playerName) { this.playerName = playerName; }

  public void setInPrison(boolean inPrison) {
    this.inPrison = inPrison;
  }

  public void setPrisonCount(int prisonCount){
    this.prisonCount = prisonCount;
  }

  public void setIsOnHappyCard(boolean isOnHappyCard) { this.isOnHappyCard = isOnHappyCard; }

  public void setPosition(int position) {

    if (position > 39) {
      position -= 39;
      this.position = position;

      System.out.println("You pass start, you will receive 4000");
      depositMoney(4000);

    }

    this.position = position;

  }

  public void setPairsInRow(int pairsInRow) { this.pairsInRow = pairsInRow; }

  // Method
  public void depositMoney(int money) {
    System.out.println("Deposit: " + money);
    this.money += money;
    System.out.println(getPlayerName() + " new balance is: " + this.money);
  }

  public void withdrawMoney(int withdrawMoney) {

// We are using an absolute value to insure that the players input is always valid

    if (Math.abs(withdrawMoney) > this.money) {
      System.out.println(getPlayerName() + " don't have enough money.");
    } else {
      System.out.println("Withdraw: " + Math.abs(withdrawMoney));
      this.money -= Math.abs(withdrawMoney);
    }
    System.out.println(getPlayerName() + " new balance is: " + this.money);
  }

  public void addCards(Ownable ownable) {
    cardsOwned.add(ownable);
  }
  public void addHappyCard(HappyCard happyCard) { happyCardsOwned.add(happyCard); }

  public String toString() {
    return "Players name is: " + playerName + "\nThe account balance is: " + money;
  }

  public void getCards() {

    if (cardsOwned.size() == 0) {
      System.out.println("You have no cards yet");
    }

    for (Ownable n : cardsOwned) {
      System.out.println("Property: " + n.getName());
    }
  }

  public void getHappyCards() {

    if (happyCardsOwned.size() == 0) {
      System.out.println("You have no cards yet");
    }

    for (HappyCard n : happyCardsOwned) {
      System.out.println("Happy Card: " + n.getNumber());
    }
  }

  public int getCountShipping() {

    int count = 0;

    for (int i = 0; i < cardsOwned.size(); i++) {
      if (cardsOwned.get(i) instanceof Shipping)
        count++;
    }
    return count;
  }

  public int getCountBrewery() {

    int count = 0;

    for (int i = 0; i < cardsOwned.size(); i++) {
      if (cardsOwned.get(i) instanceof Brewery)
        count++;
    }
    return count;
  }




}
