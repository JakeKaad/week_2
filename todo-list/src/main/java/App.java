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

      // we are either using the existing array list or creating a new one
      // if it doesn't already exist.
      ArrayList<Todo> todos;
      if (request.session().attribute("todos") instanceof ArrayList) {
        todos = request.session().attribute("todos");
      } else {
        todos = new ArrayList<Todo>();
        request.session().attribute("todos", todos);
      }

      // Makes a new todo using description from user
      String description = request.queryParams("description");
      Todo newTodo = new Todo(description);

      // adds new todo to todos arraylist and then puts it back into session
      todos.add(newTodo);
      // return null necessary because lambdas expect a return statement.
      response.redirect("/");
      return null;
    });
  }
}
