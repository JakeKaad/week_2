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
      model.put("template", "templates/index.vtl");
      model.put("todos", request.session().attribute("todos"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/todos", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      ArrayList<Todo> todos;
      if (request.session().attribute("todos") instanceof ArrayList) {
        todos = request.session().attribute("todos");
      } else {
        todos = new ArrayList<Todo>();
      }

      String description = request.queryParams("description");
      Todo newTodo = new Todo(description);
      todos.add(newTodo);

      request.session().attribute("todos", todos);
      response.redirect("/");
      return null;
    });
  }
}


ArrayList<Rectangle> todos = new ArrayList<Rectangle>();
