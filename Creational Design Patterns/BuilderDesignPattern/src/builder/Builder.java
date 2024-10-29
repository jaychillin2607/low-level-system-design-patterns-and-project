package builder;

public interface Builder {
  public Builder reset();

  public Builder setStatues(boolean x);

  public Builder setGarden(boolean x);

  public Builder setGarage(boolean x);

  public Builder setPool(boolean x);
}