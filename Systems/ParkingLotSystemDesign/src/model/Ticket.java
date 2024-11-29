package model;

public class Ticket {
  private String ticketId;
  private long entryTime;
  private ParkingSpot parkingSpot;
  private Vehicle vehicle;

  public Ticket(String id, ParkingSpot spot, Vehicle vehicle) {
    this.ticketId = id;
    this.entryTime = System.currentTimeMillis();
    this.parkingSpot = spot;
    this.vehicle = vehicle;
  }

  public String getTicketId() {
    return ticketId;
  }

  public long getEntryTime() {
    return entryTime;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public ParkingSpot getParkingSpot() {
    return parkingSpot;
  }
}
