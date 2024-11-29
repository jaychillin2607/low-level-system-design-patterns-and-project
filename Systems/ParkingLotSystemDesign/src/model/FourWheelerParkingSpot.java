package model;

public class FourWheelerParkingSpot extends ParkingSpot {
  public FourWheelerParkingSpot(int id) {
    super(id, 25, null);
  }

  public FourWheelerParkingSpot(int id, float price, Vehicle vehicle) {
    super(id, price, vehicle);
  }
}
