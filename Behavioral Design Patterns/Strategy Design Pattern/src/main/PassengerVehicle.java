package main;

import strategy.NormalDriveStrategy;

// class PassengerVehicle extends Vehicle {
// }

class PassengerVehicle extends Vehicle {
  PassengerVehicle() {
    super(new NormalDriveStrategy());
  }
}