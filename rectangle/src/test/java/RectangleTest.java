import org.junit.*;
import static org.junit.Assert.*;

public class RectangleTest {

  @Test
  public void isSquare_allSidesEqual_true() {
    Rectangle testRectangle = new Rectangle();
    assertEquals(true, testRectangle.isSquare(2, 2));
  }

  @Test
  public void isSquare_widthAndHeightDifferent_false() {
    Rectangle testRectangle = new Rectangle();
    assertEquals(false, testRectangle.isSquare(2, 4));
  }

  @Test
  public void checkRectangle_withEqualSides_true() {
    Rectangle testRectangle = new Rectangle();
    Rectangle rectangleObject = new Rectangle(2, 2);
    boolean isSquare = testRectangle.isSquare(rectangleObject.getLength(), rectangleObject.getWidth());
    assertEquals(true, isSquare);
  }

  @Test
  public void mIsSquare_withEqualSides_true() {
    Rectangle testRectangle = new Rectangle(2, 2);
    assertEquals(true, testRectangle.isSquare());
  }

  @Test
  public void mIsSquare_widthAndHeightDifferent_false() {
    Rectangle testRectangle = new Rectangle(2, 4);
    assertEquals(false, testRectangle.isSquare());
  }
}
