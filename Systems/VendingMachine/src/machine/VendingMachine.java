package machine;

import model.*;
import model.state.State;
import model.state.impl.*;
import java.util.List;
import java.util.ArrayList;

public class VendingMachine {
  private final int inventorySize;
  private State vendingMachineState;
  private Inventory inventory;
  private int currentAmount;

  private List<SelectedItem> cart;

  public VendingMachine(int inventorySize) {

    vendingMachineState = new IdleState(this);
    this.inventorySize = inventorySize;
    inventory = new Inventory(inventorySize);
    currentAmount = 0;
    cart = new ArrayList<>();
  }

  public State getVendingMachineState() {
    return vendingMachineState;
  }

  public int getInventorySize() {
    return inventorySize;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public int getCurrentAmount() {
    return currentAmount;
  }

  public void setCurrentAmount(int amount) {
    this.currentAmount = amount;
  }

  public void setVendingMachineState(State state) {
    this.vendingMachineState = state;
  }

  public void addSelectedItemToCart(SelectedItem selectedItem) {
    cart.add(selectedItem);
  }

  public List<SelectedItem> getCart() {
    return cart;
  }

  public int getCartCost() {
    int cost = 0;
    for (SelectedItem item : cart) {
      cost += item.getQty() * inventory.getItem(item.getCode()).getPrice();
    }
    return cost;
  }

  public void processTransaction() throws Exception {
    for (SelectedItem selectedItem : cart) {
      ItemShelf itemShelf = inventory.getItemShelf(selectedItem.getCode());
      if (itemShelf.getStock() < selectedItem.getQty()) {
        throw new Exception("not enough Stock");
      }
    }

    for (SelectedItem selectedItem : cart) {
      ItemShelf itemShelf = inventory.getItemShelf(selectedItem.getCode());
      itemShelf.setStock(itemShelf.getStock() - selectedItem.getQty());
    }

  }
}