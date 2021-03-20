package matadorGame.fields;

import matadorGame.player.Player;


import java.util.Scanner;

public class PrisonVisit extends Field {

  public PrisonVisit(String name, int number) {
    super(name, number);
  }

  private Scanner scanner = new Scanner(System.in);
  private int penalty = 1000;

  @Override
  public void landOnField(Player player) {
    if (!player.inPrison()) {
      System.out.println("Your visiting the prison");
    } else {
      if (player.getPrisonCount() == 0) { // Check how many rounds player has been in prison, if > 3 then pay
        player.setPrisonCount(1);
      }

      leavePrison(player);
    }

  }

  @Override
  public String toString() {
    return null;
  }

  public void leavePrison(Player player) {
    prisonOptions();
    int option = scanner.nextInt();
    scanner.nextLine();

    if (player.getPrisonCount() <= 3) {
      switch (option) {
        case 1:
          player.getDiceCup().throwDice(player);
          if (player.getDiceCup().isPair()) {
            System.out.println("You rolled " + player.getDiceCup().getDiceOne().getDice() + " and " + player.getDiceCup().getDiceTwo().getDice() + ", you are out");
            player.setInPrison(false);
            player.setPrisonCount(0);
          } else {
            System.out.println("You rolled " + player.getDiceCup().getDiceOne().getDice() + " and " + player.getDiceCup().getDiceTwo().getDice() + ", you are not out");
            player.setPrisonCount(player.getPrisonCount() + 1);
          }
          break;
        case 2:
          player.withdrawMoney(penalty);
          player.setInPrison(false);
          player.setPrisonCount(0);
          break;
        case 3:
          // use happy card.. (:
          break;
        default:
          // prøv igen
      }
    }

    if (player.getPrisonCount() > 3) {
      System.out.println("You have tried all 3 rounds, so your need to pay and then you are out");
      player.withdrawMoney(penalty);
      player.setInPrison(false);
      player.setPrisonCount(0);
    }


  }

  private void prisonOptions() {
    System.out.println("Options\n1. throw Dice\n2. Pay penalty\n3. Use happy card");
    System.out.print("Enter option: ");
  }
}
