import java.util.ArrayList;

class Deck {
  public static final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
  public static final String[] VALUES = {
    "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
  };

  private ArrayList<Card> mCards;

  public Deck() {
    mCards = new ArrayList<Card>();
    for (String suit : SUITS) {
      for ( String value : VALUES){
        Card card = new Card(suit, value);
        mCards.add(card);
      }
    }
  }
}
