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

  @Test
  public void all_returnsAllInstancesOfCar_true() {
    Car firstCar = new Car("Toyota", 2004, "Red");
    Car secondCar = new Car("Toyota", 2004, "Red");
    assertTrue(Car.all().indexOf(firstCar) > -1);
  }

  @Test
  public void newID_carsInstantiatiesWithId_true() {
    Car newCar = new Car("Toyota", 2004, "Red");
    assertEquals(Car.all().size(), newCar.getId() );
  }

  @Test
  public void find_returnsCarWithSameID_firstCar() {
    Car firstCar = new Car("Toyota", 2004, "Red");
    assertEquals(Car.find(firstCar.getId()), firstCar);
  }
}
