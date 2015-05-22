
import org.junit.*;
import static org.junit.Assert.*;

public class TodoTest {

  @Test
  public void todo_instantiatesCorrectly_true() {
    Todo myTodo = new Todo("Mow the lawn");
    assertEquals(true, myTodo instanceof Todo);
  }

  @Test
  public void todo_instantiatesWithDescription_true() {
    Todo myTodo = new Todo("Mow the lawn");
    assertEquals("Mow the lawn", myTodo.getDescription());
  }
}
