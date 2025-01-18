package models;

public class Payment {
  private int paymentId;
  private boolean paymentStatus;

  public Payment(int paymentId, boolean paymentStatus) {
    this.paymentId = paymentId;
    this.paymentStatus = paymentStatus;
  }
}