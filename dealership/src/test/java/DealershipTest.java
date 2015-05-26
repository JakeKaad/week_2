import org.junit.*;
import static org.junit.Assert.*;

public class DealershpTest {

  @Test
  public void getName_returnsName_true() {
    Dealership testDealership = new Dealership("Bob's Used Cars");
    assertEquals("Bob's Used Cars", testDealership.getName());
  }

  @Test
  public void getId_returnsDealershipId() {
    Dealership testDealership = new Dealership("Bob's Used Cars");
    assertTrue(Dealership.all().length == testDealership.getId());
  }

  @Test
  public void getCars_initiallyReturnsEmptyArrayList() {
    Dealership testDealership = new Dealership("Bob's Used Cars");
    assertTrue(testDealership.getCars() instanceof ArrayList);
  }

  @Test
  public void find_returnsDealershipWithSameId() {
    Dealership testDealership = new Dealership("Bob's Used Cars");
    assertEquals(Dealership.find(testDealership.getId()), testDealership);
  }
}
