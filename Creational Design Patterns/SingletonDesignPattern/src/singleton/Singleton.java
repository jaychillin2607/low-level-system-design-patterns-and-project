package singleton;

public class Singleton {
  private static Singleton instance;

  private Singleton() {
    System.err.println("Singleton object created!");
  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
