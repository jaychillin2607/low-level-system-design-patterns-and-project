package vendingMachineState;

import java.util.Scanner;
import vendingMachine.*;

public class IdleState extends VendingMachineState {
  public IdleState(VendingMachine vm, Inventory inv) {
    super(vm, inv);
    System.out.println("Vending Machine is in Idle State!");
  }

  @Override
  public void pressInsertCoinButton() {
    System.out.println("Pressed InsertCoinButton!");
    this.vendingMachine.setVendingMachineState(new HasCashState(this.vendingMachine, this.inventory));
  }

  @Override
  public void restockInventory() {
    this.inventory.displayInventory();
    int code;
    int stock;
    Scanner scan = new Scanner(System.in);
    try {
      System.out.print("Enter item code: ");
      code = scan.nextInt();
      System.out.print("Enter item quantity: ");
      stock = scan.nextInt();
      this.inventory.reStock(code, stock);
    } catch (Exception e) {
      System.out.println("invalid input!");
    }
    scan.close();
  }

}
