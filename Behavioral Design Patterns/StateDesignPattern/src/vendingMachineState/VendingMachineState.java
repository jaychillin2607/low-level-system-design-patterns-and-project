package vendingMachineState;

import vendingMachine.*;

public abstract class VendingMachineState {
  protected VendingMachine vendingMachine;
  protected Inventory inventory;

  public VendingMachineState(VendingMachine vendingMachine, Inventory inventory) {
    this.vendingMachine = vendingMachine;
    this.inventory = inventory;
  }

  public void pressInsertCoinButton() throws Exception {
    throw new Exception("invalid operation!");
  }

  public void insertCoin(Coin coin) throws Exception {
    throw new Exception("invalid operation!");
  }

  public void selectProductButton() throws Exception {
    throw new Exception("invalid operation!");
  }

  public int cancelOrRefund() throws Exception {
    throw new Exception("invalid operation!");
  }

  public void chooseProduct() throws Exception {
    throw new Exception("invalid operation!");
  }

  public int returnChange() throws Exception {
    throw new Exception("invalid operation!");
  }

  public void dispenseProductButton() throws Exception {
    throw new Exception("invalid operation!");
  }

  public void productDispensing() throws Exception {
    throw new Exception("invalid operation!");
  }

  public void restockInventory() throws Exception {
    throw new Exception("invalid operation!");
  }
}
