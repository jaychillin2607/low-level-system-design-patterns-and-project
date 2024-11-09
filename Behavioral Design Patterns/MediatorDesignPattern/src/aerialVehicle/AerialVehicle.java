package aerialVehicle;

import atc.ATC;

public class AerialVehicle {
  private String vehicleType;
  private String vehicleId;
  private ATC atc;

  public AerialVehicle(String type, String id, ATC atc) {
    this.vehicleType = type;
    this.vehicleId = id;
    this.atc = atc;
    
    atc.addVehicle(this);
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public void notify(String message) {
    System.out.println(message);
  }

  public void requestLanding(){
    atc.requestLanding(this);
  }
}
