import org.junit.*;
import static org.junit.Assert.*;

public class CardTest {

  @Test
  public void card_initializesCorrectly_true() {
    Card testCard = new Card("Spades", "Ace");
    assertEquals(true, testCard instanceof Card);
  }

  @Test
  public void getSuit_returnsACardsSuit_Spades() {
    Card testCard = new Card("Spades", "Ace");
    assertEquals("Spades", testCard.getSuit());
  }

  @Test
  public void getValue_returnsACardsSuit_Ace() {
    Card testCard = new Card("Spades", "Ace");
    assertEquals("Ace", testCard.getValue());
  }

  @Test
  public void name_returnsAFormattedNameForCard_AceOfSpades() {
    Card testCard = new Card("Spades", "Ace");
    assertEquals("Ace of Spades", testCard.name());
  }
}
