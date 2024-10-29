import builder.HouseBuilder;
import director.Director;
import product.House;

class Main {
  public static void main(String[] args) {

    HouseBuilder houseBuilder = new HouseBuilder();

    Director director = new Director();

    director.createBigHouse(houseBuilder);

    House bigHouse = houseBuilder.getHouse();
    System.out.println(bigHouse);

    director.createHouseWithPool(houseBuilder);

    House houseWithPool = houseBuilder.getHouse();
    System.out.println(houseWithPool);

  }
}
