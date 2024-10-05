package abstractfactory;

import product.Chair;
import product.ModernChair;
import product.ModernSofa;
import product.ModernTable;
import product.Sofa;
import product.Table;

public class ModernFurnitureSet implements FurnitureSet {
  public Chair createChair() {
    return new ModernChair();
  }

  public Sofa createSofa() {
    return new ModernSofa();
  }

  public Table createTable() {
    return new ModernTable();
  }
}
