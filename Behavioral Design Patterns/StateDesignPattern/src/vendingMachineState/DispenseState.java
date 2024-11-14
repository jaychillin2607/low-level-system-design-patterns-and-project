package vendingMachineState;

import vendingMachine.*;

public class DispenseState extends VendingMachineState {
  private final int selectedCode;

  public DispenseState(VendingMachine vm, Inventory i, int code) {
    super(vm, i);
    selectedCode = code;
    System.out.println("Vending Machine is in Dispense State!");
  }

  @Override
  public void productDispensing() {
    System.out.println("Dispensing a " + Utils.getItemName(this.inventory.getItem(selectedCode).getItemType()));

    this.vendingMachine.setVendingMachineState(new IdleState(vendingMachine, inventory));
  }
}
