package handlers;

public abstract class LogProcessor {
  public final int INFO = 1;
  public final int DEBUG = 2;
  public final int ERROR = 3;

  LogProcessor next;

  LogProcessor(LogProcessor next) {
    this.next = next;
  }

  public abstract void handleLog(int logLevel, String message);

  public void log(int logLevel, String message) {
    handleLog(logLevel, message);
  }
}
