package service;

public class RoundHole {
  private double radius;

  public RoundHole(double radius) {
    this.radius = radius;
  }

  public boolean doesItFit(RoundPeg rp) {
    return this.radius >= rp.getRadius();
  }
}