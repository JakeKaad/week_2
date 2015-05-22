import java.util.ArrayList;

import org.junit.*;
import static org.junit.Assert.*;

public class DealershipTest {

  @Test
  public void dealership_instantiatesCorrectly_true() {
    Dealership ronTonkin = new Dealership("Ron Tonkin");
    assertEquals(true, ronTonkin instanceof Dealership);
  }

  @Test
  public void getName_dealershipHasAName_name() {
    Dealership ronTonkin = new Dealership("Ron Tonkin");
    assertEquals("Ron Tonkin", ronTonkin.getName());
  }


  @Test
  public void addCar_putsaNewCarInDealershipCarsArrayList_true() {
    Dealership ronTonkin = new Dealership("Ron Tonkin");
    Car newCar = new Car("Toyota", 2004, "Red");
    ronTonkin.addCar(newCar);
    assertEquals(false, ronTonkin.getCars().isEmpty());
  }
}
