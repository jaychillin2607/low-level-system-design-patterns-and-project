package abstractions;

import implementations.Color;

public class Circle extends Shape {
  private float radius;

  public Circle(float radius, Color color) {
    super(color);
    this.radius = radius;
  }

  @Override
  public float getArea() {
    return (float) (3.14 * radius * radius);
  }

  @Override
  public float getPerimeter() {
    return (float) (2 * 3.14 * radius);
  }

}
