import java.util.ArrayList;

public class Dealership {
  private String mName;
  private ArrayList<Car> mCars;

  public Dealership(String name) {
    mName = name;
    mCars = new ArrayList<Car>();
  }

  public String getName() {
    return mName;
  }

  public ArrayList<Car> getCars() {
    return mCars;
  }

  public void addCar(Car car) {
    mCars.add(car);
  }
}
