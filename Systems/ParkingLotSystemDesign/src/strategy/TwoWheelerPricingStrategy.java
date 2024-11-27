package strategy;

import model.Ticket;

public class TwoWheelerPricingStrategy extends PricingStrategy {
  public TwoWheelerPricingStrategy(Ticket ticket) {
    super(ticket);
  }

  public float getParkingFee() {
    float price = this.ticket.getParkingSpot().getPrice();
    long timeTaken = System.currentTimeMillis() - this.ticket.getEntryTime();
    return Math.max(price, price * timeTaken);
  };
}