package model;

import model.enums.VehicleType;

public class Vehicle {
  private String vehicleId;
  private VehicleType type;

  public Vehicle(String id, VehicleType type) {
    this.vehicleId = id;
    this.type = type;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public VehicleType getVehicleType() {
    return type;
  }
}
