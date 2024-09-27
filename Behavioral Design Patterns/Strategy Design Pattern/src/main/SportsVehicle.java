package main;

import strategy.SportsDriveStrategy;

// Without Strategy Pattern
// class SportsVehicle extends Vehicle {
//   @Override
//   public void drive() {
//     System.out.println("Sports drive capability.");
//   }
// }

class SportsVehicle extends Vehicle {
  SportsVehicle() {
    super(new SportsDriveStrategy());
  }
}