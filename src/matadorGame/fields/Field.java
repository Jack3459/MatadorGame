package matadorGame.fields;

import matadorGame.player.Player;

public abstract class Field {

  private String name;
  private int number;

  // Constructor
  public Field(String name, int number){
    this.name = name;
    this.number = number;

  }

  // Getter
  public int getNumber() { return number; }
  public String getName() { return name; }

  // Method
  public abstract void landOnField(Player player);


  public abstract String toString();

}
