package matadorGame.cards;

public class HappyCard {

  private String doSomething;
  private int number;



  public HappyCard(int  number, String doSomething){
    this.doSomething = doSomething;
    this.number = number;
  }



  // Getter

  public int getNumber() {
    return number;
  }

  public String getDoSomething() {
    return doSomething;
  }
// Setter

}
