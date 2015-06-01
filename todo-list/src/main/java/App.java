import java.util.ArrayList;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("todos", request.session().attribute("todos"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/todos", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      ArrayList<Todo> todos = request.session().attribute("todos");

      if (todos == null) {
        todos = new ArrayList<Todo>();
        request.session().attribute("todos", todos);
      }

      String description = request.queryParams("description");
      Todo newTodo = new Todo(description);

      todos.add(newTodo);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
