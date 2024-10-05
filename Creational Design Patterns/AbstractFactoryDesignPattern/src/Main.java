import product.Chair;
import product.Table;
import product.Sofa;

import abstractfactory.*;

public class Main {
  public static void main(String[] args) {
    // Gothic furniture set
    FurnitureSet gothicFurnitureFactory = new GothicFurnitureSet();
    Chair gothicChair = gothicFurnitureFactory.createChair();
    Sofa gothicSofa = gothicFurnitureFactory.createSofa();
    Table gothicTable = gothicFurnitureFactory.createTable();

    // using gothic furniture
    gothicChair.sit();
    gothicSofa.lay();
    gothicTable.place();

    // Modern furniture set
    FurnitureSet modernFurnitureFactory = new ModernFurnitureSet();
    Chair modernChair = modernFurnitureFactory.createChair();
    Sofa modernSofa = modernFurnitureFactory.createSofa();
    Table modernTable = modernFurnitureFactory.createTable();

    // using modern furniture
    modernChair.sit();
    modernSofa.lay();
    modernTable.place();
  }
}