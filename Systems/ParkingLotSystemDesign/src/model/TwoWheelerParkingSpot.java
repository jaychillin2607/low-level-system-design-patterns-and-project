package model;

public class TwoWheelerParkingSpot extends ParkingSpot {
  public TwoWheelerParkingSpot(int id) {
    super(id, 10, null);
  }

  public TwoWheelerParkingSpot(int id, float price, Vehicle vehicle) {
    super(id, price, vehicle);
  }
}
