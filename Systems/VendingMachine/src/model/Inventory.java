package model;

public class Inventory {
  ItemShelf inventory[];

  public Inventory(int size) {
    inventory = new ItemShelf[size];
    initializeInventory();
  }

  public void initializeInventory() {
    int startCode = 101;
    for (int i = 0; i < inventory.length; i++) {
      inventory[i] = new ItemShelf(null, startCode++, 0);
    }
  }

  public ItemShelf[] getInventoryShelves() {
    return inventory;
  }

  public void setInventory(ItemShelf[] inventory) {
    this.inventory = inventory;
  }

  public Item getItem(int code) {
    ItemShelf itemShelf = getItemShelf(code);
    if (itemShelf != null)
      return itemShelf.getItem();
    return null;
  }

  public ItemShelf getItemShelf(int code) {
    for (ItemShelf itemShelf : inventory) {
      if (itemShelf.getCode() == code)
        return itemShelf;
    }
    return null;
  }

  public void setItem(int code, Item item, int stock) {
    ItemShelf itemShelf = getItemShelf(code);
    if (itemShelf != null) {
      itemShelf.setItem(item);
      itemShelf.setStock(stock);
    } else {
      System.out.println("no item with code:" + code);
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