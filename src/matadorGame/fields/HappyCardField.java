package matadorGame.fields;

import matadorGame.cards.DeckOfCards;
import matadorGame.cards.HappyCard;
import matadorGame.player.Player;

public class HappyCardField extends Field {

  private DeckOfCards deckOfCards = new DeckOfCards();

  public HappyCardField(String name, int number) {
    super(name, number);
  }

  @Override
  public void landOnField(Player player) {

    player.addHappyCard(deckOfCards.drawCard());

  }

  @Override
  public String toString() {
    return null;
  }
}
