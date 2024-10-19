package handlers;

public class ErrorLogProcessor extends LogProcessor {

  public ErrorLogProcessor(LogProcessor next) {
    super(next);
  }

  @Override
  public void handleLog(int logLevel, String message) {
    if (logLevel == ERROR) {
      System.out.printf("\u001B[31mERROR - %s \u001B[0m\n", message);
    }
  };

}
