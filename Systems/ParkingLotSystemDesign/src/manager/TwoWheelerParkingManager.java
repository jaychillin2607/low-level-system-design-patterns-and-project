package manager;

import java.util.ArrayList;

import strategy.TwoWheelerParkingStrategy;
import model.ParkingSpot;

public class TwoWheelerParkingManager extends ParkingSpotManager {

  public TwoWheelerParkingManager() {
    super(new TwoWheelerParkingStrategy(new ArrayList<ParkingSpot>(400)));
  }
}