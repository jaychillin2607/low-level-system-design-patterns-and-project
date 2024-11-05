import abstractions.*;
import implementations.*;

public class Main {
  public static void main(String[] args) {
    Color blue = new Blue();
    Color red = new Red();
    Shape circle = new Circle(7, blue);
    Shape rectangle = new Rectangle(5, 4, red);

    circle.applyColor();
    rectangle.applyColor();
  }
}
