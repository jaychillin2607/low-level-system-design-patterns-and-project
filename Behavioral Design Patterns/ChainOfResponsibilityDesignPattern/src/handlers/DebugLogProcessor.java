package handlers;

public class DebugLogProcessor extends LogProcessor {

  public DebugLogProcessor(LogProcessor next) {
    super(next);
  }

  @Override
  public void handleLog(int logLevel, String message) {
    if (logLevel == DEBUG) {
      System.out.printf("\u001B[33mDEBUG - %s \u001B[0m\n", message);

    } else {
      super.next.handleLog(logLevel, message);
    }
  };

}
