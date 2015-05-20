import org.junit.*;
import static org.junit.Assert.*;

public class TriangleTest {


  @Test
  public void testTriangleType_allSidesEqual_equilateral() {
    Triangle testTriangle = new Triangle();
    String type = testTriangle.triangleType(2, 2, 2);
    assertEquals(type, "equilateral");
  }

  @Test
  public void testTriangleType_twoSidesEqual_isosceles() {
    Triangle testTriangle = new Triangle();
    String type = testTriangle.triangleType(2, 2, 3);
    assertEquals(type, "isosceles");
  }

  @Test
  public void testTriangleType_noSidesEqual_scalene() {
    Triangle testTriangle = new Triangle();
    String type = testTriangle.triangleType(2, 3, 4);
    assertEquals(type, "scalene");
  }

  @Test
  public void testTriangleType_illegalSides_notATriangle() {
    Triangle testTriangle = new Triangle();
    String type = testTriangle.triangleType(1, 2, 3);
    assertEquals(type, "not a triangle");
  }

  @Test
  public void testTriangleConstructor_instantiatesWithType() {
    Triangle testTriangle = new Triangle(2, 2, 2);
    assertEquals(testTriangle.getType().isEmpty(), false);
  }
}
