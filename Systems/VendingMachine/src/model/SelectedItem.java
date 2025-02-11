package model;

public class SelectedItem {
  private final int code;
  private final int qty;

  public SelectedItem(int code, int qty) {
    this.code = code;
    this.qty = qty;
  }

  public int getCode() {
    return code;
  }

  public int getQty() {
    return qty;
  }

  @Override
  public String toString() {
    return String.format("Code: %d || Qty: %d", code, qty);
  }

}