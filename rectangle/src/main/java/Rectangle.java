
public class Rectangle {
  private Integer mLength;
  private Integer mWidth;

  public Rectangle() {}

  public Rectangle(Integer length, Integer width) {
    mLength = length;
    mWidth = width;
  }

  public static Boolean isSquare(Integer length, Integer width) {
    return length == width;
  }

  public Boolean isSquare() {
    return mLength == mWidth;
  }

  public Integer getLength() {
    return mLength;
  }

  public Integer getWidth() {
    return mWidth;
  }
}
