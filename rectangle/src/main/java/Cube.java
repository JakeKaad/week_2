public class Cube {
  Rectangle mSquare;

  public Cube(Rectangle rectangle) {
    mSquare = rectangle;
  }

  public int volume() {
    int length = mSquare.getLength();
    return length * length * length;
  }

  public int surfaceArea() {
    return mSquare.area() * 6;
  }
}
