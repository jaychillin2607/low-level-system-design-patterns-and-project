package builder;

import product.House;

public class HouseBuilder implements Builder {
  private boolean statues, pool, garden, garage;

  @Override
  public Builder reset() {
    this.statues = false;
    this.pool = false;
    this.garden = false;
    this.garage = false;
    return this;
  }

  @Override
  public Builder setStatues(boolean x) {
    this.statues = x;
    return this;
  }

  @Override
  public Builder setGarden(boolean x) {
    this.garden = x;
    return this;
  }

  @Override
  public Builder setGarage(boolean x) {
    this.garage = x;
    return this;
  }

  @Override
  public Builder setPool(boolean x) {
    this.pool = x;
    return this;
  }

  public House getHouse() {
    House product = new House(
        this.statues,
        this.garden,
        this.pool,
        this.garage);
    this.reset();
    return product;
  }
}
