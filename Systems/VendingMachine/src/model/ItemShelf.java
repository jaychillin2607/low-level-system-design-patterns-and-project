package model;

public class ItemShelf {
  private Item item;
  private int code;
  private int stock;

  public ItemShelf(Item item, int code, int stock) {
    this.item = item;
    this.code = code;
    this.stock = stock;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public boolean isStockOut() {
    return stock == 0;
  }
}