package factory;

import strategy.PricingStrategy;
import strategy.TwoWheelerPricingStrategy;
import strategy.FourWheelerPricingStrategy;
import model.Ticket;
import model.enums.VehicleType;

public class PricingStrategyFactory {
  public static PricingStrategy createPricingStrategy(Ticket ticket) {
    switch (ticket.getVehicle().getVehicleType()) {
      case VehicleType.TWO_WHEELER:
        return new TwoWheelerPricingStrategy(ticket);
      case VehicleType.FOUR_WHEELER:
        return new FourWheelerPricingStrategy(ticket);
      default:
        return null;
    }
  }
}