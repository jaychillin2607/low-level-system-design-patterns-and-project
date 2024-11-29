package strategy;

import java.util.List;
import model.ParkingSpot;
import model.TwoWheelerParkingSpot;

public class TwoWheelerParkingStrategy extends ParkingStrategy {
  public TwoWheelerParkingStrategy(List<ParkingSpot> spots) {
    super(spots);
  }

  public ParkingSpot findParkingSpot() {
    for (ParkingSpot availableSpot : parkingSpots) {
      if (availableSpot.isParkingSpotEmpty()) {
        return availableSpot;
      }
    }
    ParkingSpot availableSpot = new TwoWheelerParkingSpot(parkingSpots.size());
    parkingSpots.add(availableSpot);
    return availableSpot;
  }
}