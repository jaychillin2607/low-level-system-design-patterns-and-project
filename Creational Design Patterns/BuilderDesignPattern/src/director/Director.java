package director;

import builder.Builder;

public class Director {

  public Builder createBigHouse(Builder builder) {
    builder.setGarage(true).setGarden(true).setPool(true).setStatues(true);
    return builder;
  }

  public Builder createSmallHouse(Builder builder) {
    builder.reset();
    return builder;
  }

  public Builder createHouseWithPool(Builder builder) {
    builder.setPool(true);
    return builder;
  }
}
