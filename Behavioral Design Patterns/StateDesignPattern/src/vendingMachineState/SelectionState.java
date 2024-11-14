package vendingMachineState;

import java.util.Scanner;
import vendingMachine.*;

public class SelectionState extends VendingMachineState {
  private int selectedItemCode = 0;

  public SelectionState(VendingMachine vm, Inventory i) {
    super(vm, i);
    System.out.println("Vending Machine is in Selection State!");
  }

  @Override
  public void chooseProduct() {
    Scanner scan = new Scanner(System.in);
    System.out.print("Choose the code of item you want: ");
    selectedItemCode = scan.nextInt();
    scan.close();
    System.out.println("Item selected: " + Utils.getItemName(this.inventory.getItem(selectedItemCode).getItemType()));

  }

  @Override
  public int cancelOrRefund() {
    int value = this.vendingMachine.getTotalMoney();
    this.vendingMachine.clearCoins();
    return value;
  }

  @Override
  public void dispenseProductButton() {
    System.out.println("Pressed Dispense Product button!");
    int change = returnChange();
    System.out.println("Dispensed change: " + change);
    this.vendingMachine
        .setVendingMachineState(new DispenseState(this.vendingMachine, this.inventory, selectedItemCode));
  }

  @Override
  public int returnChange() {
    int price = this.inventory.getItemPrice(selectedItemCode);
    int amount = this.vendingMachine.getTotalMoney();
    if (amount < price) {
      System.out.println("Insufficient amount add more money!");
      this.vendingMachine.setVendingMachineState(new HasCashState(this.vendingMachine, this.inventory));
      return -1;
    }
    this.vendingMachine.clearCoins();

    return amount - price;
  }
}
