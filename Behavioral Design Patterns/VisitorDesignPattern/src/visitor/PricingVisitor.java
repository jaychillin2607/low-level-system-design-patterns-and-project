package visitor;

import hotel.*;

public class PricingVisitor implements Visitor {

  @Override
  public void visitSingleRoom(SingleRoom room) {
    System.out.printf("Price of Single room is %f\n", room.getRoomPrice());
  }

  @Override
  public void visitDoubleRoom(DoubleRoom room) {
    System.out.printf("Price of Double room is %f\n", room.getRoomPrice());
  }

  @Override
  public void visitDeluxeRoom(DeluxeRoom room) {
    System.out.printf("Price of Deluxe room is %f\n", room.getRoomPrice());
  }
}
