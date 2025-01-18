package models;

import models.enums.SeatCategory;

public class Seat {
  private int id;
  private String seatNumber;
  private SeatCategory category;

  public Seat(int id, String seatNumber, SeatCategory category) {
    this.id = id;
    this.seatNumber = seatNumber;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public String getSeatNumber() {
    return seatNumber;
  }

  public SeatCategory getSeatCategory() {
    return category;
  }

  @Override
  public boolean equals(Object m) {
    Seat seat = (Seat) m;
    return seat.getId() == id;
  }
}