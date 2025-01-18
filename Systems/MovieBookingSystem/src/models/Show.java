package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
  private int id;
  private Movie movie;
  private LocalDateTime startTime;
  private List<Seat> bookedSeats;
  private Screen screen;

  public Show(int id, Movie movie, LocalDateTime startTime, Screen screen) {
    this.id = id;
    this.movie = movie;
    this.startTime = startTime;
    this.screen = screen;
    bookedSeats = new ArrayList<>();
  }

  public void addBookedTicket(Seat seat) {
    bookedSeats.add(seat);
  }

  public int getId() {
    return id;
  }

  public Movie getMovie() {
    return movie;
  }

  public Screen getScreen() {
    return screen;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public List<Seat> getBookedSeats() {
    return bookedSeats;
  }

  public List<Integer> getBookedSeatIds() {
    List<Integer> list = new ArrayList<>();
    for (Seat seat : bookedSeats) {
      list.add(seat.getId());
    }
    return list;
  }

}