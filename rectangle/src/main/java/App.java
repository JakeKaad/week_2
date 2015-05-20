
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      response.redirect("/home");
      return null;
    });

    get("/home", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();


      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/rectangle", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Integer length = Integer.parseInt(request.queryParams("length"));
      Integer width = Integer.parseInt(request.queryParams("width"));

      Rectangle myRectangle = new Rectangle(length, width);
      model.put("myRectangle", myRectangle);

      model.put("template", "templates/rectangle.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
