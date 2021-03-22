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
          break;
        case 3:
          // show happy card
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
        \t\033[5mMATADOR\033[0m
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
