import org.junit.*;
import static org.junit.Assert.*;

public class CarTest {

  @Test
  public void car_instantiatesCorrectly_true() {
    Car newCar = new Car("Toyota", 2004, "Red");
    assertEquals(true, newCar instanceof Car);
  }

  @Test
  public void car_instantiatesWithMake_true() {
    Car newCar = new Car("Toyota", 2004, "Red");
    assertEquals("Toyota", newCar.getMake());
  }

  @Test
  public void car_instantiatesWithYear_true() {
    Car newCar = new Car("Toyota", 2004, "Red");
    assertEquals(2004, newCar.getYear());
  }

  @Test
  public void car_instantiatesWithColor_true() {
    Car newCar = new Car("Toyota", 2004, "Red");
    assertEquals("Red", newCar.getColor());
  }
}
