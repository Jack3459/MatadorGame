package matadorGame.cards;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

  private ArrayList<HappyCard> deckCards = new ArrayList<>();
  private int top;

  public DeckOfCards() {
    renderDeck();
    shuffleDeck();
  }

  // Getter


  public ArrayList<HappyCard> getDeckCard() { return deckCards; }

  public void renderDeck() {

    deckCards.add(new HappyCard(1, "Move to Start. Deposit 4000."));
    deckCards.add(new HappyCard(2, "Move to Grenaa-Hundestad, if you pass start deposit 4000."));
    deckCards.add(new HappyCard(3, "Move 3 rows forward."));
    deckCards.add(new HappyCard(4, "Pay 3000 for reparation of van."));
    deckCards.add(new HappyCard(5, "Get out of jail free card."));

    top = deckCards.size() - 1;
  }

  public void printDeck() {

    for (HappyCard d : deckCards
    ) {
      System.out.println(d.getNumber() + ". " + d.getDoSomething());
    }
  }

  public void shuffleDeck() {

    Collections.shuffle(deckCards);

  }

  public HappyCard drawCard() {
    if (top < 0) {
      System.out.println("No more cards, shuffling the deck...");
      shuffleDeck();
      top = deckCards.size() - 1;
    }

    System.out.println(deckCards.get(top).getNumber() + ". " + deckCards.get(top).getDoSomething());
    top -= 1;



    return deckCards.get(top + 1);
  }

}
