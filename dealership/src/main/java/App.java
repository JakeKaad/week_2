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
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cars", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cars", Car.all());
      model.put("template", "templates/cars.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("cars/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/car-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cars/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Car car = Car.find(Integer.parseInt(request.params(":id")));
      model.put("car", car);
      model.put("template", "templates/car.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cars", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String inputtedMake = request.queryParams("carMake");
      int inputtedYear = Integer.parseInt(request.queryParams("carYear"));
      String inputtedColor = request.queryParams("carColor");
      Car newCar = new Car(inputtedMake, inputtedYear, inputtedColor);

      model.put("car", newCar);
      model.put("template", "templates/car.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
