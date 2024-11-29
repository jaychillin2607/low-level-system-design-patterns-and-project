package manager;

import strategy.ParkingStrategy;
import model.ParkingSpot;
import model.Vehicle;
import model.Ticket;

public class ParkingSpotManager {
  private ParkingStrategy strategy;

  public ParkingSpotManager(ParkingStrategy strategy) {
    this.strategy = strategy;
  }

  public ParkingSpot findParkingSpot() {
    return strategy.findParkingSpot();
  }

  public void parkVehicle(Vehicle vehicle) {
    ParkingSpot spot = findParkingSpot();
    spot.parkVehicle(vehicle);
  }

  public void removeVehicle(Ticket ticket) {
    ParkingSpot spot = ticket.getParkingSpot();
    spot.removeVehicle();
  }
}
