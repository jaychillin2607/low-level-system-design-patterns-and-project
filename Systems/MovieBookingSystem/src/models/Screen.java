package models;

import java.util.List;

public class Screen {
  private int id;
  private List<Seat> seats;

  public Screen(int id, List<Seat> seats) {
    this.id = id;
    this.seats = seats;
  }

  public void addSeat(Seat seat) {
    seats.add(seat);
  }

  public int getId() {
    return id;
  }

  public List<Seat> getSeats() {
    return seats;
  }
}