package hotel;

import visitor.Visitor;

public class DeluxeRoom extends Room {

  public DeluxeRoom(int num, float price) {
    super(num, price);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitDeluxeRoom(this);
  }

}
