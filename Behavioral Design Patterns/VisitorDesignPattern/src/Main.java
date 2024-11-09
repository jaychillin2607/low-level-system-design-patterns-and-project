import java.util.*;

import hotel.*;
import visitor.*;

public class Main {
  public static void main(String[] args) {
    SingleRoom singleRoom = new SingleRoom(1, 100);
    DoubleRoom doubleRoom = new DoubleRoom(2, 200);
    DeluxeRoom deluxeRoom = new DeluxeRoom(3, 300);
    ArrayList<Room> rooms = new ArrayList<>();
    rooms.add(singleRoom);
    rooms.add(doubleRoom);
    rooms.add(deluxeRoom);

    PricingVisitor pricingVisitor = new PricingVisitor();
    MaintenanceVisitor maintenanceVisitor = new MaintenanceVisitor();

    for (Room room : rooms) {
      room.accept(pricingVisitor);
      room.accept(maintenanceVisitor);
    }
  }
}
