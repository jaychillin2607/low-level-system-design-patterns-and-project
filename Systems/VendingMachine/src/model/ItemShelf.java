package model;

public class ItemShelf {
  private Item item;
  private int code;
  private int stock;
  private boolean stockOut;

  public ItemShelf(Item item, int code, int stock) {
    this.item = item;
    this.code = code;
    this.stock = stock;
    stockOut = false;
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

  public void set(int stock) {
    this.stock = stock;
    if (this.stock == 0) {
      stockOut = true;
    }
  }

  public boolean isStockOut() {
    return stockOut;
  }

}