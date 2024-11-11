package adapter;

import client.SquarePeg;
import service.RoundPeg;

public class SquarePegAdapter extends RoundPeg {
  private SquarePeg sp;

  public SquarePegAdapter() {
  }

  public SquarePegAdapter(SquarePeg sp) {
    this.sp = sp;
  }

  @Override
  public double getRadius() {
    return this.sp.getWidth() * (1.4142) * (0.5);
  }

  public void setSquarePeg(SquarePeg sp) {
    this.sp = sp;
  }

}
