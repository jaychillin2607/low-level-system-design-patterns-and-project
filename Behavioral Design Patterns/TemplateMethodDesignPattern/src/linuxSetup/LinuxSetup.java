package linuxSetup;

import systemSetup.SystemSetup;

public class LinuxSetup extends SystemSetup {

  public LinuxSetup(String OSName) {
    super(OSName);
  }

  @Override
  public void driveSetup() {
    System.out.println("Setting up /home /etc ...");
  }

  @Override
  public void installOS() {
    System.out.printf("Installing %s\n", this.getOSName());
  }

  @Override
  public void installDrivers() {
    System.out.println("Installing vendor specific drivers for network and other hardware");
  }

  @Override
  public void installUtilitySoftwares() {
    System.out.println("Installing LibraOffice");
  }

  @Override
  public void initializeUserCreation() {
    System.out.println("Setup account using any provider google, microsoft, facebook, etc");
  };
}