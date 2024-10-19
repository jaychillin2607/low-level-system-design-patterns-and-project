package handlers;

public class InfoLogProcessor extends LogProcessor {

  public InfoLogProcessor(LogProcessor next) {
    super(next);
  }

  @Override
  public void handleLog(int logLevel, String message) {
    if (logLevel == INFO) {
      System.out.printf("INFO - %s\n", message);
    } else {
      super.next.handleLog(logLevel, message);
    }
  };

}
