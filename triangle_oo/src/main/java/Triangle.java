public class Triangle {
  private String mType;
  private Integer mSideA;
  private Integer mSideB;
  private Integer mSideC;

  public Triangle() {}

  public Triangle(Integer sideA, Integer sideB, Integer sideC) {
    mSideA = sideA;
    mSideB = sideB;
    mSideC = sideC;
    mType = triangleType(mSideA, mSideB, mSideC);
  }

  public String getType() {
    return mType;
  }


  public static String triangleType(Integer sideA, Integer sideB, Integer sideC) {
    if ((sideA + sideB <= sideC) ||
        (sideB + sideC <= sideA) ||
        (sideA + sideC <= sideB)) {
      return "not a triangle";
    } else if ( sideA == sideB && sideB == sideC) {
      return "equilateral";
    } else if ((sideA == sideB && sideA != sideC) ||
               (sideA == sideC && sideA != sideB) ||
               (sideB == sideC && sideB != sideA)) {
      return "isosceles";
    } else {
      return "scalene";
    }
  }
}
