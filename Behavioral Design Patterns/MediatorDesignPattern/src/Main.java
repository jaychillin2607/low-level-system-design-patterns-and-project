import atc.*;
import aerialVehicle.*;

public class Main {
  public static void main(String[] args) {
    ATC atc = new ATC();

    AerialVehicle charteredJet = new AerialVehicle("Jet Plane", "1", atc);
    AerialVehicle passengerJet = new AerialVehicle("Jet Plane", "2", atc);
    AerialVehicle cargoPlane = new AerialVehicle("Cargo Plane", "3", atc);

    charteredJet.requestLanding();
    cargoPlane.requestLanding();
    passengerJet.requestLanding();
  }
}
