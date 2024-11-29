package strategy;

import java.util.List;
import model.ParkingSpot;

public abstract class ParkingStrategy {
  protected List<ParkingSpot> parkingSpots;

  public ParkingStrategy(List<ParkingSpot> spots) {
    this.parkingSpots = spots;
  }

  public abstract ParkingSpot findParkingSpot();
}