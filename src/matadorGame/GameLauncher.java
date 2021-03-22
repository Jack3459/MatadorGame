package matadorGame;

import matadorGame.moves.PlayMatador;

import java.util.Scanner;

public class GameLauncher {

  private PlayMatador playMatador = new PlayMatador();
  private Scanner scanner = new Scanner(System.in);

  // Constructor
  public GameLauncher() {
  }


  // Method

  public void launchOptions() {

    boolean quit = false;

    while (!quit) {

      optionsMenu();
      System.out.print(">: ");
      int option = scanner.nextInt();
      scanner.nextLine();

      switch (option) {

        case 0:
          quit = true;
          break;
        case 1:
          startGame();
          break;
        case 2:
          // show ownable
          playMatador.getGameBoard().printOwnable();
          System.out.println();
          break;
        case 3:
          // show happy card
          playMatador.getDeckOfCards().printDeck();
          System.out.println();
          break;
        default:
          System.out.println("Not valid");
          break;

      }
    }
  }

  public void optionsMenu() {
    System.out.println(
        """
        \tMATADOR
        \t1. Start Game
        \t2. See all cards
        \t3. See all happy cards
        \t0. To quit
        """
    );
  }



  // Start game metod

  public void startGame() {
    playMatador.startGame();
  }

  public void run() {
    launchOptions();
  }


}
