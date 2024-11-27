package manager;

import factory.ParkingManagerFactory;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;

import java.util.UUID;

public class EntranceGate {
  private Vehicle vehicle;
  private ParkingSpotManager parkingManager;

  public EntranceGate(Vehicle v) {
    this.vehicle = v;
    this.parkingManager = ParkingManagerFactory.createParkingManager(vehicle);
  }

  private ParkingSpot findParkingSpot() {
    return parkingManager.findParkingSpot();
  }

  public Ticket parkVehicle() {
    ParkingSpot availableSpot = findParkingSpot();
    availableSpot.parkVehicle(vehicle);
    System.out.printf(
        "%s vehicle with id: %s has been parked at parking spot id: %d\n",
        vehicle.getVehicleType(),
        vehicle.getVehicleId(),
        availableSpot.getParkingSpotId());
    return generateTicket(availableSpot);
  }

  private Ticket generateTicket(ParkingSpot spot) {
    return new Ticket(UUID.randomUUID().toString(), spot, vehicle);
  }
}
