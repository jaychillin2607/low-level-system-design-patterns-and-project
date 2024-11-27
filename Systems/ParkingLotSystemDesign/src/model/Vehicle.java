package model;

import model.enums.VehicleType;

public class Vehicle {
  private String vehicleId;
  private VehicleType type;
  private Ticket ticket;

  public Vehicle(String id, VehicleType type) {
    this.vehicleId = id;
    this.type = type;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public Ticket getTicket() {
    return ticket;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public VehicleType getVehicleType() {
    return type;
  }
}
