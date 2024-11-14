package vendingMachine;

public class Inventory {
  private Item[] items;

  public Inventory(int numOfItems) {
    items = new Item[numOfItems];
  }

  public void reStock(int code, int stock) {
    Item item = items[code - 1];
    item.reStock(stock);
  }

  public int getItemPrice(int code) {
    return items[code - 1].getPrice();
  }

  public boolean buy(int code, int money) {
    return items[code - 1].buyItem();
  }

  public Item getItem(int code) {
    return items[code - 1];
  }

  public void displayInventory() {
    System.out.println("-------------****-------------");
    for (int i = 0; i < items.length; i++)
      System.out.println(items[i].display(i + 1));
    System.out.println("-------------****-------------");
  }

  public void fillUpInventory() {
    for (int i = 0; i < items.length; i++) {
      switch (i % 4) {
        case 0:
          items[i] = new Item(30, 1, ItemType.PEPSI);
          break;
        case 1:
          items[i] = new Item(25, 1, ItemType.COKE);
          break;
        case 2:
          items[i] = new Item(15, 1, ItemType.DR_PEPPER);
          break;
        default:
          items[i] = new Item(50, 1, ItemType.COFFEE);
      }
    }
  }
}