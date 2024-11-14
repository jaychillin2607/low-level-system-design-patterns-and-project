package vendingMachineState;

import vendingMachine.*;

public class HasCashState extends VendingMachineState {
  public HasCashState(VendingMachine vm, Inventory i) {
    super(vm, i);
    System.out.println("Vending Machine is in Has Cash State!");
  }

  @Override
  public void insertCoin(Coin coin) {
    this.vendingMachine.addCoin(coin);
    System.out.println("Added a " + Utils.getCoinName(coin));
  }

  @Override
  public void selectProductButton() {
    System.out.println("Pressed select item button!");
    this.vendingMachine.setVendingMachineState(new SelectionState(this.vendingMachine, this.inventory));
  }

  @Override
  public int cancelOrRefund() {
    int amount = this.vendingMachine.getTotalMoney();
    System.out.println("Dispensing " + amount + " cents!");

    return amount;
  }

}
