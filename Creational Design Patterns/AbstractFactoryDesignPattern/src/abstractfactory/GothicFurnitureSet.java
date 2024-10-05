package abstractfactory;

import product.Chair;
import product.Table;
import product.Sofa;
import product.GothicChair;
import product.GothicTable;
import product.GothicSofa;

public class GothicFurnitureSet implements FurnitureSet {
  public Chair createChair() {
    return new GothicChair();
  }

  public Sofa createSofa() {
    return new GothicSofa();
  }

  public Table createTable() {
    return new GothicTable();
  }
}