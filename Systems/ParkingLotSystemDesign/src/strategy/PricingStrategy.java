package strategy;

import model.Ticket;

public abstract class PricingStrategy {
  protected Ticket ticket;

  public PricingStrategy(Ticket ticket) {
    this.ticket = ticket;
  }

  public abstract float getParkingFee();
}