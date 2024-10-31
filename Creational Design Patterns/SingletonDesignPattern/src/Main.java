import singleton.Singleton;

public class Main {
  public static void main(String[] args) {
    Singleton obj = Singleton.getInstance();

    // creation message will be printed only once
    Singleton newObj = Singleton.getInstance();

  }
}
