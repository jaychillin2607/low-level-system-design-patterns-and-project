package model;

public class Inventory {
  ItemShelf inventory[];

  public Inventory(int count) {
    inventory = new ItemShelf[count];
  }

  public void initializeInventory() {
    int startCode = 101;
    for (int i = 0; i < inventory.length; i++) {
      inventory[i] = new ItemShelf(null, startCode++, 0);
    }
  }

  public ItemShelf[] getInventory() {
    return inventory;
  }

  public void setInventory(ItemShelf[] inventory) {
    this.inventory = inventory;
  }

  public Item getItem(int code) {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == code)
        return itemShelf.getItem();
    }
    return null;
  }

  public void setItem(int code, Item item, int stock) {
    for (int i = 0; i < inventory.length; i++) {
      if (inventory[i].getCode() == code) {
        inventory[i].setItem(item);
        inventory[i].setStock(stock);
        return;
      }
    }
  }

  public void reStockItem(int code, int stock) {
    for (int i = 0; i < inventory.length; i++) {
      if (inventory[i].getCode() == code) {
        inventory[i].setStock(inventory[i].getStock() + stock);
        return;
      }
    }
  }

}