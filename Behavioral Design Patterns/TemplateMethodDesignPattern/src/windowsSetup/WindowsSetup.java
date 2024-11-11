package windowsSetup;

import systemSetup.SystemSetup;

public class WindowsSetup extends SystemSetup {

  public WindowsSetup(String OSName) {
    super(OSName);
  }

  @Override
  public void driveSetup() {
    System.out.println("Setting up localDisk:c and localDisk:d ...");
  }

  @Override
  public void installOS() {
    System.out.printf("Installing %s\n", this.getOSName());
  }

  @Override
  public void installDrivers() {
    System.out.println("Drivers comes along with Windows");
  }

  @Override
  public void installUtilitySoftwares() {
    System.out.println("Installing MSOffice");
  }

  @Override
  public void initializeUserCreation() {
    System.out.println("Setup account using microsoft");
  };
}