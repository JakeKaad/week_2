public class Car {
  private static int currentId = 0;

  private String mMake;
  private int mYear;
  private String mColor;
  private int mId;

  public Car(String make, int year, String color) {
    mMake = make;
    mYear = year;
    mColor = color;
    mId = newId();
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

  private int newId() {
    Integer id = new Integer(currentId);
    currentId++;
    return id.intValue();
  }
}
