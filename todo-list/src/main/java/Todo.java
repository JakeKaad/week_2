public class Todo {
  private String mDescription;
  private Boolean mFinished;

  public Todo(String description) {
    mDescription = description;
    mFinished = false;
  }

  public String getDescription() {
    return mDescription;
  }

  public Boolean isFinished() {
    return mFinished;
  }
}
