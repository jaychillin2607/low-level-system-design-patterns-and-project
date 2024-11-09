package visitor;

import hotel.*;

public interface Visitor {
  public void visitSingleRoom(SingleRoom room);

  public void visitDoubleRoom(DoubleRoom room);

  public void visitDeluxeRoom(DeluxeRoom room);
}