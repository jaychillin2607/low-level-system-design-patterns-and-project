package abstractfactory;

import product.Chair;
import product.Table;
import product.Sofa;

public interface FurnitureSet {
  public Chair createChair();

  public Sofa createSofa();

  public Table createTable();
}