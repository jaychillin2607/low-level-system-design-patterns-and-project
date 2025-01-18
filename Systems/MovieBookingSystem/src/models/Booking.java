package models;

public class Booking {
  private int id;
  private Show show;
  private Seat seat;
  private Payment payment;
  private Theatre theatre;

  public Booking(int id, Show show, Seat seat, Theatre theatre) {
    this.id = id;
    this.show = show;
    this.seat = seat;
    this.theatre = theatre;
  }

  public int getId() {
    return id;
  }

  public Show getShow() {
    return show;
  }

  public Seat getSeat() {
    return seat;
  }

  public Theatre getTheatre() {
    return theatre;
  }

  public Payment getPayment() {
    return payment;
  }
}