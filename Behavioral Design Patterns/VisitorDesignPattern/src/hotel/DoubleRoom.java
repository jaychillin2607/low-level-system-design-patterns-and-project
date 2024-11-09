package hotel;

import visitor.Visitor;

public class DoubleRoom extends Room {

  public DoubleRoom(int num, float price) {
    super(num, price);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitDoubleRoom(this);
  }

}
