package matadorGame;

import matadorGame.cards.DeckOfCards;
import matadorGame.player.Player;

public class TestFields {

  private static Player player1 =new Player("Mo");
  private static Player player2 = new Player("Jackie");
  private static Player player3 = new Player("Christoffer");
  private static Player player4 = new Player("Kamille");
  private static GameBoard gameBoard = new GameBoard();


  public static void main(String[] args) {


    //gameBoard.renderBoard();
    gameBoard.printBoard();

/*    gameBoard.fields.get(8).landOnField(player1);
    gameBoard.fields.get(22).landOnField(player1);
    player2.getDiceCup().throwDice(player2);
    //System.out.println(player2.getDiceCup().getDiceSum());

    gameBoard.fields.get(22).landOnField(player2);
    player3.getDiceCup().throwDice(player3);
    gameBoard.fields.get(22).landOnField(player3);*/



    /* test prison
    gameBoard.fields[30].landOnField(player3);
    gameBoard.fields[player3.getPosition()].landOnField(player3);
    gameBoard.fields[player3.getPosition()].landOnField(player3);
    gameBoard.fields[player3.getPosition()].landOnField(player3);
     */

    /* test buy option
    gameBoard.fields[3].landOnField(player3);
    player3.getCards();
gameBoard.fields[12].landOnField(player3);
    player3.getCards();
     */

    gameBoard.fields[2].landOnField(player1);
    gameBoard.fields[2].landOnField(player1);
    player1.getHappyCards();
    gameBoard.fields[2].landOnField(player1);
    gameBoard.fields[2].landOnField(player1);
    player1.getHappyCards();




  }

}
