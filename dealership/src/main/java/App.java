
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

      model.put("dealership", request.session().attribute("dealership"));
      model.put("template", "templates/dealership.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("dealerships/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String name = request.queryParams("dealershipName");
      Dealership newDealership = new Dealership(name);
      request.session().attribute("dealership", newDealership);
      model.put("dealership", newDealership);
      model.put("template", "templates/new-dealership.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("cars/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/cars-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("cars", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      String inputtedMake = request.queryParams("carMake");
      int inputtedYear = Integer.parseInt(request.queryParams("carYear"));
      String inputtedColor = request.queryParams("carColor");

      Car newCar = new Car(inputtedMake, inputtedYear, inputtedColor);
      Dealership myDealership = request.session().attribute("dealership");
      myDealership.addCar(newCar);

      model.put("car", newCar);
      model.put("template", "template/car.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
