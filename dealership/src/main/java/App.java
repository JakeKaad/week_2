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

    get("/dealerships", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("dealerships", Dealership.all());
      model.put("template", "templates/dealerships.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("dealerships/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/dealership-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/dealerships/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Dealership dealership = Dealership.find(Integer.parseInt(request.params(":id")));
      model.put("dealership", dealership);
      model.put("template", "templates/dealership.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/dealerships", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String inputtedName = request.queryParams("name");
      Dealership newDealership = new Dealership("name");
      model.put("dealership", newDealership);
      model.put("template", "templates/dealership.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cars", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("cars", Car.all());
      model.put("template", "templates/cars.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("dealerships/:id/cars/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("dealership", Dealership.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/dealership-cars-form.vtl");
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
      Dealership dealership = Dealership.find(Integer.parseInt(request.queryParams("dealershipId")));
      dealership.addCar(newCar);
      model.put("dealership", dealership);
      model.put("template", "templates/dealership.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
