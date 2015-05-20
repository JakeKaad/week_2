import org.junit.*;
import static org.junit.Assert.*;

public class TodoTest {

  @Test
  public void todo_instantiatesCorrectly() {
    Todo myTodo = new Todo("Mow the lawn");
    assertEquals("Mow the lawn", myTodo.getDescription());
    assertEquals(false, myTodo.isFinished());
  }
}
