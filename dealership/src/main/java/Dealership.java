import java.util.ArrayList;

public class Dealership {
  private static ArrayList<Dealership> instances = new ArrayList<Dealership>();

  private String mName;
  private int mId;
  private ArrayList<Car> mCars;

  public Dealership(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mCars = new ArrayList<Car>();
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public ArrayList<Car> getCars() {
    return mCars;
  }

  public void addCar(Car car) {
    mCars.add(car);
  }

  public static ArrayList<Dealership> all() {
    return instances;
  }

  public static Dealership find(int id) {
    Dealership foundDealership = null;
    for (Dealership dealership : instances) {
      if (dealership.getId() == id) {
        foundDealership = dealership;
      }
    }
    return foundDealership;
  }
}
