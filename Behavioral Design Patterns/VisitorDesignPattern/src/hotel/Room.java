package hotel;

import visitor.Visitor;

public abstract class Room {

  private int roomNumber;
  private float roomPrice;

  public Room(int num, float price) {
    this.roomNumber = num;
    this.roomPrice = price;
  }

  public abstract void accept(Visitor visitor);

  public int getRoomNumber() {
    return roomNumber;
  }

  public float getRoomPrice() {
    return roomPrice;
  }

}
