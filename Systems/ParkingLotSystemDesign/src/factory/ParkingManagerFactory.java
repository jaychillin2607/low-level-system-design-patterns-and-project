package factory;

import manager.FourWheelerParkingManager;
import manager.ParkingSpotManager;
import manager.TwoWheelerParkingManager;
import model.Vehicle;
import model.enums.VehicleType;

public class ParkingManagerFactory {
  public static ParkingSpotManager createParkingManager(Vehicle vehicle) {
    switch (vehicle.getVehicleType()) {
      case VehicleType.TWO_WHEELER:
        return new TwoWheelerParkingManager();
      case VehicleType.FOUR_WHEELER:
        return new FourWheelerParkingManager();
      default:
        return null;
    }
  }
}