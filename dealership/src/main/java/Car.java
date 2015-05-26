import java.util.ArrayList;

public class Car {
  private static ArrayList<Car> instances = new ArrayList<Car>();

  private String mMake;
  private int mYear;
  private String mColor;
  private int mId;

  public Car(String make, int year, String color) {
    mMake = make;
    mYear = year;
    mColor = color;
    instances.add(this);
    mId = instances.size() + 1;
  }

  public String getMake() {
    return mMake;
  }

  public int getYear() {
    return mYear;
  }

  public String getColor() {
    return mColor;
  }

  public int getId() {
    return mId;
  }

  public  static ArrayList<Car> all() {
    return instances;
  }

  public static Car find(int id) {
    Car foundCar = null;
    for (Car car : instances) {
      if (car.getId() == id) {
        foundCar = car;
      }
    }
    return foundCar;
  }
}
