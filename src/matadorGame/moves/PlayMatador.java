package matadorGame.moves;

import matadorGame.GameBoard;
import matadorGame.cards.DeckOfCards;
import matadorGame.cards.HappyCard;
import matadorGame.cards.HappyCardAction;
import matadorGame.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayMatador {

  private boolean gameOver = false;
  private int move;

  private ArrayList<Player> players = new ArrayList<>();

  private GameBoard gameBoard = new GameBoard();
  private DeckOfCards deckOfCards = new DeckOfCards();
  private HappyCardAction happyCardAction = new HappyCardAction();
  private Scanner scanner = new Scanner(System.in);

  public PlayMatador() {
  }

  // Method
  public void playOptions(Player player) {

    boolean playing = true;

    //while (playing) {

    if (!player.inPrison()) {

      printPlayOptions(player);
      System.out.print(">: ");
      int option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {

        case 0:
          cheat(player);
          movePlayerCheat(player);
          break;
        case 1:
          movePlayer(player);
          break;
        case 2:
          //Buy house
          break;
        case 3:
          System.out.println("You have: " + player.getMoney() + "$");
          playOptions(player);
          break;
        case 4:
          player.getCards();
          playOptions(player);
          break;
        case 5:
          player.getHappyCards();
          playOptions(player);
          break;
        default:
          System.out.println("Not valid");
          break;

      }
    } else {
      //noget

      gameBoard.getFields()[player.getPosition()].landOnField(player);

      if (!player.inPrison()) {
        // gameBoard.getFields()[player.getPosition() + player.getDiceCup().getDiceSum()].landOnField(player);
        playOptions(player);
      }

    }
    //}
  }


  public void printPlayOptions(Player player) {
    System.out.println("\n\t" +
        player.getPlayerName() +
        "'s Turn, you are at field nr. " +
        (player.getPosition() + 1));

    System.out.println(
        """
            \t1. Throw dice
            \t2. Buy house
            \t3. See money
            \t4. See cards
            \t5. See happy cards
            """
    );
  }

  private void addPlayer() {
    System.out.println("How many players are you?");
    System.out.print(">: ");
    int playerAmount = scanner.nextInt();
    scanner.nextLine();

    for (int i = 1; i <= playerAmount; i++) {
      System.out.println("Enter player " + i + "'s name");
      System.out.print(">: ");
      String name = scanner.nextLine();
      players.add(new Player(name));
    }

  }

  public void movePlayer(Player player) {
    move = 0;
    player.getDiceCup().throwDice(player);
    int diceThrow = player.getDiceCup().getDiceSum();

    player.setPosition(player.getPosition() + diceThrow);
    System.out.println("Field position: " + (player.getPosition() + 1));

    move = player.getPosition();

    gameBoard.getFields()[move].landOnField(player);

    if (player.isOnHappyCard()) {
      ifPlayerHitHappyCard(player);
    }

    ifPlayerHitPair(player); // one more turn if pair

  }

  private void ifPlayerHitHappyCard(Player player) {

    HappyCard drawnHappyCard = deckOfCards.drawCard();

    int happyCardNumberIndex = deckOfCards.getDeckCard().indexOf(drawnHappyCard);

    happyCardAction.cardDrawn(drawnHappyCard.getNumber(), player, drawnHappyCard);

    if (player.isPlayerMoved()) {
      //if the player got a new position
      gameBoard.getFields()[player.getPosition()].landOnField(player);

      player.setPlayerMoved(false); //stop moving
    }

    //player.addHappyCard(); // To get out of prison free card
    player.setIsOnHappyCard(false);

  }

  private void ifPlayerHitPair(Player player) {

    if (player.getDiceCup().isPair()) {
      System.out.println("Hit pair");
      player.setPairsInRow(player.getPairsInRow() + 1);
      if (player.getPairsInRow() < 3) {
        playOptions(player);
      } else {
        System.out.println("You hit pair in 3 rows, move to prison.");
        player.setInPrison(true); // go to prison;
        player.setPosition(10); // moves to prison
        player.setPairsInRow(0); // reset pairs in row
      }
    } else {
      player.setPairsInRow(0); // reset pairs in row
    }
  }

  public void startGame() {
    addPlayer();


    for (int i = 0; i < players.size(); i++) {
      playOptions(players.get(i));

      if (i == players.size() - 1) {
        i = -1; // to start over with player 1 (index 0)
      } else if (gameOver) {
        i = players.size() - 1;
      }

    }
  }


  private void cheat(Player player) {

    //cheats options
    System.out.println("WARNING, DONT USE CHEAT");
    System.out.print("Enter dice one number: ");
    int dice = scanner.nextInt();
    player.getDiceCup().getDiceOne().setDiceCheat(dice);

    System.out.print("Enter dice two number: ");
    dice = scanner.nextInt();
    scanner.nextLine();
    player.getDiceCup().getDiceTwo().setDiceCheat(dice);

  }

  public void movePlayerCheat(Player player) {
    move = 0;

    int diceThrow = player.getDiceCup().getDiceSum();

    player.setPosition(player.getPosition() + diceThrow);
    System.out.println("Field position: " + (player.getPosition() + 1));

    move = player.getPosition();

    gameBoard.getFields()[move].landOnField(player);

    if (player.isOnHappyCard()) {
      ifPlayerHitHappyCard(player);
    }

    ifPlayerHitPair(player); // one more turn if pair

  }

}

