package abstractions;

import implementations.Color;

public class Rectangle extends Shape {
  private float length, breadth;

  public Rectangle(float length, float breadth, Color color) {
    super(color);
    this.length = length;
    this.breadth = breadth;
  }

  @Override
  public float getArea() {
    return length * breadth;
  }

  @Override
  public float getPerimeter() {
    return 2 * (length + breadth);
  }

}
