package manager;

import java.util.ArrayList;

import strategy.FourWheelerParkingStrategy;
import model.ParkingSpot;

public class FourWheelerParkingManager extends ParkingSpotManager {

  public FourWheelerParkingManager() {
    super(new FourWheelerParkingStrategy(new ArrayList<ParkingSpot>(400)));
  }
}