package visitor;

import hotel.*;

public class MaintenanceVisitor implements Visitor {

  @Override
  public void visitSingleRoom(SingleRoom room) {
    System.out.printf("Maintenance for room no.: %d\n", room.getRoomNumber());
  }

  @Override
  public void visitDoubleRoom(DoubleRoom room) {
    System.out.printf("Maintenance for room no.: %d\n", room.getRoomNumber());
  }

  @Override
  public void visitDeluxeRoom(DeluxeRoom room) {
    System.out.printf("Maintenance for room no.: %d\n", room.getRoomNumber());
  }
}
