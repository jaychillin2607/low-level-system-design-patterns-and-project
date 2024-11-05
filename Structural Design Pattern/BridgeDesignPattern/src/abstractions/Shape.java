package abstractions;

import implementations.Color;

public abstract class Shape {
  protected Color color;

  public Shape(Color color) {
    this.color = color;
  }

  public abstract float getArea();

  public abstract float getPerimeter();

  public void applyColor() {
    color.apply();
  }
}
