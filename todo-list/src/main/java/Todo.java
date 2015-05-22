public class Todo {
  private String mDescription;
  private boolean mFinished;

  public Todo(String description) {
    mDescription = description;
    mFinished = false;
  }

  public String getDescription() {
    return mDescription;
  }


  public boolean isFinished() {
    return mFinished;
  }
}
