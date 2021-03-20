package matadorGame;

import matadorGame.player.Player;

public class MatadorMain {
  public static Player player1 = new Player("John");

  public static void main(String[] args){
    System.out.println(player1.getMoney());
    player1.depositMoney(500);
    player1.withdrawMoney(-300);
    player1.withdrawMoney(30300);
    System.out.println(player1.toString());




  }
}
