import java.util.UUID;

import manager.EntranceGate;
import manager.ExitGate;
import model.Vehicle;
import model.Ticket;
import model.enums.VehicleType;

public class Main {
  public static void main(String[] args) {
    // Four Wheeler
    Vehicle fourWV = new Vehicle(UUID.randomUUID().toString(), VehicleType.FOUR_WHEELER);
    EntranceGate entranceGate = new EntranceGate(fourWV);
    Ticket fourWVT = entranceGate.parkVehicle();
    ExitGate exitGate = new ExitGate(fourWVT);
    exitGate.removeVehicle();

    // Two Wheeler
    Vehicle twoWV = new Vehicle(UUID.randomUUID().toString(), VehicleType.TWO_WHEELER);
    entranceGate = new EntranceGate(twoWV);
    Ticket twoWVT = entranceGate.parkVehicle();
    exitGate = new ExitGate(twoWVT);
    exitGate.removeVehicle();
  }
}
