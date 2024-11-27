package strategy;

import java.util.List;
import model.ParkingSpot;
import model.FourWheelerParkingSpot;

public class FourWheelerParkingStrategy extends ParkingStrategy {
  public FourWheelerParkingStrategy(List<ParkingSpot> spots) {
    super(spots);
  }

  public ParkingSpot findParkingSpot() {
    for (ParkingSpot availableSpot : parkingSpots) {
      if (availableSpot.isParkingSpotEmpty()) {
        return availableSpot;
      }
    }
    ParkingSpot availableSpot = new FourWheelerParkingSpot(parkingSpots.size());
    parkingSpots.add(availableSpot);
    return availableSpot;
  }
}