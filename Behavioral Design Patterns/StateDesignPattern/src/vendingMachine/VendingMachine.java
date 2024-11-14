package vendingMachine;

import java.util.ArrayList;
import vendingMachineState.*;

public class VendingMachine {
  private Inventory inventory;
  private VendingMachineState state;
  private ArrayList<Coin> coins;

  public VendingMachine(int inventorySize) {
    inventory = new Inventory(inventorySize);
    state = new IdleState(this, inventory);
    coins = new ArrayList<>();
  }

  public void setVendingMachineState(VendingMachineState vms) {
    this.state = vms;
  }

  public int getTotalMoney() {
    int sum = 0;
    for (Coin coin : coins) {
      sum += Utils.getCoinValue(coin);
    }
    return sum;
  }

  public void addCoin(Coin coin) {
    coins.add(coin);
  }

  public void clearCoins() {
    this.coins.clear();
  }

  public void displayInventory() {
    this.inventory.displayInventory();
  }

  public VendingMachineState getState() {
    return this.state;
  }

  public void fillUpMachine() {
    this.inventory.fillUpInventory();
  }
}