import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Square finder");
  }

  @Test
  public void squareTestIsASquare() {
    goTo("http://localhost:4567/");
    fill("#length").with("5");
    fill("#width").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("Your rectangle is a square!");
  }

  @Test
  public void squareTestIsNotASquare() {
    goTo("http://localhost:4567/");
    fill("#length").with("7");
    fill("#width").with("5");
    submit(".btn");
    assertThat(pageSource()).contains("Your rectangle isn't a square!");
  }
}
