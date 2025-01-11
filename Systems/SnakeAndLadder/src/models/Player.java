package models;

public class Player {
  private String id;
  private int currentPosition;

  public Player(String id, int pos) {
    this.id = id;
    currentPosition = pos;
  }

  public String getId() {
    return id;
  }

  public int getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(int pos){
    currentPosition = pos;
  }

  @Override 
  public String toString(){
    return id;
  }
}
