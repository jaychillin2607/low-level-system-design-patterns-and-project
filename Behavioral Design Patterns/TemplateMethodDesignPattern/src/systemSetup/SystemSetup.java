package systemSetup;

public abstract class SystemSetup {
  private String OSName;

  public SystemSetup(String OsName) {
    this.OSName = OsName;
  }

  public String getOSName() {
    return OSName;
  }

  public abstract void driveSetup();

  public abstract void installOS();

  public abstract void installDrivers();

  public abstract void installUtilitySoftwares();

  public abstract void initializeUserCreation();

  public final void setupFirstBoot() {

    driveSetup();
    installOS();
    installDrivers();
    installUtilitySoftwares();
    initializeUserCreation();
  }
}