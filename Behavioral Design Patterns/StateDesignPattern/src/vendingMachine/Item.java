package vendingMachine;

public class Item {
  private int stock;
  private ItemType itemType;
  private int price;

  public Item(int price, int stock, ItemType type) {
    this.price = price;
    this.stock = stock;
    this.itemType = type;
  }

  public boolean buyItem() {
    if (stock > 0) {
      stock -= 1;
      return true;
    }
    return false;
  }

  public void reStock(int stock) {
    this.stock += stock;
  }

  public int getPrice() {
    return price;
  }

  public ItemType getItemType() {
    return itemType;
  }

  public String display(int code) {
    return String.format("code: %d || item: %10s || price: %d || %s", code, Utils.getItemName(itemType), price,
        (stock > 0 ? "in stock" : "out of stock"));
  }
}