package model;

public abstract class ParkingSpot {
  private int parkingSpotId;
  private float price;
  private Vehicle vehicle;
  private boolean isEmpty;

  public ParkingSpot(int id, float price, Vehicle vehicle) {
    this.parkingSpotId = id;
    this.price = price;
    this.vehicle = vehicle;
    this.isEmpty = true;
  }

  public void parkVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    this.isEmpty = false;
  }

  public Vehicle removeVehicle() {
    Vehicle vehicle = this.vehicle;
    this.vehicle = null;
    this.isEmpty = true;
    return vehicle;
  }

  public int getParkingSpotId() {
    return parkingSpotId;
  }

  public float getPrice() {
    return price;
  }

  public boolean isParkingSpotEmpty() {
    return isEmpty;
  }

}
