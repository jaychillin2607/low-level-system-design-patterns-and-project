package models;

import java.util.List;

public class Theatre {
  public int id;
  public String city;
  public List<Screen> screens;
  public List<Show> shows;

  public Theatre(int id, String city) {
    this.id = id;
    this.city = city;
  }

  public void setScreens(List<Screen> screens) {
    this.screens = screens;
  }

  public void setShows(List<Show> shows) {
    this.shows = shows;
  }

  public int getId() {
    return id;
  }

  public String getCity() {
    return city;
  }

  public List<Screen> getScreens() {
    return screens;
  }

  public List<Show> getShows() {
    return shows;
  }
}