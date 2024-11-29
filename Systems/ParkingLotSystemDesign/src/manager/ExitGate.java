package manager;

import model.Ticket;
import factory.ParkingManagerFactory;
import factory.PricingStrategyFactory;
import strategy.PricingStrategy;

public class ExitGate {
  private ParkingSpotManager parkingManager;
  private PricingStrategy pricingStrategy;
  private Ticket ticket;

  public ExitGate(Ticket ticket) {
    this.ticket = ticket;
    this.parkingManager = ParkingManagerFactory.createParkingManager(ticket.getVehicle());
    this.pricingStrategy = PricingStrategyFactory.createPricingStrategy(ticket);
  }

  private float getParkingFee() {
    return pricingStrategy.getParkingFee();
  }

  public void removeVehicle() {
    float fee = getParkingFee();
    System.out.printf("Please pay parking fee: $%.2f\n", fee);
    parkingManager.removeVehicle(ticket);
  }

}
