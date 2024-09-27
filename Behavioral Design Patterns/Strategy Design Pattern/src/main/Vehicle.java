package main;

import strategy.DriveStrategy;

/**
 * Without Strategy Pattern
 *
 * class Vehicle {
 * public void drive() {
 * System.out.println("Normal Drive capability.");
 * }
 * }
 */

class Vehicle {
  DriveStrategy driveObject;

  Vehicle(DriveStrategy driveObj) {
    this.driveObject = driveObj;
  }

  public void drive() {
    driveObject.drive();
  }
}