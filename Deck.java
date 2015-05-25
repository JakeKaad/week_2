class Deck {
  private static final String[] SUITS = {"Spades", "Clubs", "Hearts", "Diamonds"};
  private static final String[] VALUES = {
    "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
  };

  private ArrayList<Card> cards;

  public Deck() {
    cards = new ArrayList<Card>();
    for (suit : SUITS) {
      for (value : VALUES){
        Card card = new Card(suit, value);
      }
    }
  }
}

class Card {
  String mValue;
  String mSuit;

  public Card(String suit, String value) {
    mSuit = suit;
    mValue = value;
  }

  public String name() {
    return String.format("%s of %s", mValue, mSuit);
  }
}
