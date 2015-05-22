public class Car {
  private String mMake;
  private int mYear;
  private String mColor;

  public Car(String make, int year, String color) {
    mMake = make;
    mYear = year;
    mColor = color;
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
}
