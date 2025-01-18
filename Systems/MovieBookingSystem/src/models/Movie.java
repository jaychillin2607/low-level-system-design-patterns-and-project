package models;

public class Movie {
  private int id;
  private float duration;
  private String name;

  public Movie(int id, float duration, String name) {
    this.id = id;
    this.duration = duration;
    this.name = name.toLowerCase();
  }

  public int getId() {
    return id;
  }

  public float getDuration() {
    return duration;
  }

  public String getName() {
    return name;
  }

}