package atc;

import java.util.ArrayList;
import aerialVehicle.AerialVehicle;

public class ATC {
  private ArrayList<AerialVehicle> aerialVehicles;

  public ATC() {
    aerialVehicles = new ArrayList<>();
  }

  public void addVehicle(AerialVehicle vehicle) {
    aerialVehicles.add(vehicle);
  }

  public void notifyAllVehicle(AerialVehicle vehicle, String message) {
    for (AerialVehicle elem : aerialVehicles) {
      if (!vehicle.equals(elem)) {
        elem.notify(message);
      }
    }
  }

  public void requestLanding(AerialVehicle vehicle) {
    String message = String.format("Landing strip is occupied, %s id: %s is landing.\n", vehicle.getVehicleType(),
    vehicle.getVehicleId());
    notifyAllVehicle(vehicle, message);
  }

}
