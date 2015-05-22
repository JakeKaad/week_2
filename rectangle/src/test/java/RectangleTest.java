import org.junit.*;
import static org.junit.Assert.*;

public class RectangleTest {

  @Test
  public void newRectangle_instantiatesCorrectly() {
    Rectangle testRectangle = new Rectangle(2, 2);
    assertEquals(true, testRectangle instanceof Rectangle);
  }

  @Test
  public void newRectangle_setsLength() {
    Rectangle testRectangle = new Rectangle(2, 2);
    assertEquals(2, testRectangle.getLength());
  }

  @Test
  public void newRectangle_setsWidth() {
    Rectangle testRectangle = new Rectangle(2, 2);
    assertEquals(2, testRectangle.getWidth());
  }

  @Test
  public void isSquare_withEqualSides_true() {
    Rectangle testRectangle = new Rectangle(2, 2);
    assertEquals(true, testRectangle.isSquare());
  }

  @Test
  public void isSquare_widthAndHeightDifferent_false() {
    Rectangle testRectangle = new Rectangle(2, 4);
    assertEquals(false, testRectangle.isSquare());
  }
}
