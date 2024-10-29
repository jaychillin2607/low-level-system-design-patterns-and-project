package product;

public class House {
  private boolean statues;
  private boolean garden;
  private boolean pool;
  private boolean garage;

  public House(boolean statues, boolean garden, boolean pool, boolean garage) {
    this.statues = statues;
    this.garage = garage;
    this.garden = garden;
    this.pool = pool;
  }

  @Override
  public String toString() {

    return String.format(
        "This house has:%s%s%s%s",
        (this.statues ? "\nstatues" : ""),
        (this.garden ? "\ngarden" : ""),
        (this.pool ? "\npool" : ""),
        (this.garage ? "\ngarage" : ""));
  }

}