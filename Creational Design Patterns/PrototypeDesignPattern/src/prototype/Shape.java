package prototype;

public abstract class Shape {
  protected String color;

  public Shape(String color) {
    this.color = color;
  }

  protected Shape(Shape shape) {
    if (shape != null)
      this.color = shape.getColor();
  }

  public String getColor() {
    return this.color;
  }

  public abstract float area();

  public abstract float perimeter();

  public abstract Shape clone();
}
