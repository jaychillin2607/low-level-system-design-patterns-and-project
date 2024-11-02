package prototype;

public class Circle extends Shape {

  private float radius;

  public Circle(float radius, String color) {
    super(color);
    this.radius = radius;
  }

  protected Circle(Circle shape) {
    super(shape);
    if (shape != null) 
      this.radius = shape.getRadius();
  }

  public float getRadius() {
    return this.radius;
  }

  @Override
  public Circle clone() {
    return new Circle(this);
  }

  @Override
  public float area() {
    return (float) ((22 / 7) * this.radius * this.radius * 1000) / 1000;
  }

  @Override
  public float perimeter() {
    return (float) (2 * (22 / 7) * this.radius * 1000) / 1000;
  }

  public String toString(){
    return String.format("Circle of radius %.2f and %s color. Area: %.2f, Perimeter: %.2f",radius, super.color, this.area(), this.perimeter());
  }
}
