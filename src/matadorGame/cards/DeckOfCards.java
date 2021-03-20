package matadorGame.cards;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {

  private ArrayList<HappyCard> deckCards = new ArrayList<>();
  private int top;

  public void renderDeck(){

    deckCards.add(new HappyCard(1, "Do something"));
    deckCards.add(new HappyCard(2, "Do something else"));
    deckCards.add(new HappyCard(3, "Do another thing"));
    deckCards.add(new HappyCard(4, "Keep doing stuff"));
    deckCards.add(new HappyCard(5, "Do even more stuff"));

    top = deckCards.size()-1;
  }

  public void printDeck(){

    for (HappyCard d: deckCards
         ) {
      System.out.println(d.getNumber() +  ". " + d.getDoSomething());
    }
  }

  public void shuffleDeck(){

    Collections.shuffle(deckCards);

  }

  public void nextCard(){

    if (top <0){
      System.out.println("No more cards");
    }
    else
      System.out.println(deckCards.get(top).getNumber() + deckCards.get(top).getDoSomething());
      top -=1;
  }
}
