package hotel;

import visitor.Visitor;

public class SingleRoom extends Room {

  public SingleRoom(int num, float price) {
    super(num, price);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visitSingleRoom(this);
  }

}
