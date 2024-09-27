package main;

import strategy.SportsDriveStrategy;

// class OffRoadVehicle extends Vehicle {
//   @Override
//   public void drive() {
//     System.out.println("Sports drive capability.");
//   }
// }

class OffRoadVehicle extends Vehicle {
  OffRoadVehicle() {
    super(new SportsDriveStrategy());
  }
}