import machine.VendingMachine;
import model.*;
import model.enums.ItemType;
import model.state.State;

public class Main {
  public static void main(String[] args) {
    VendingMachine machine = new VendingMachine(12);
    fillInventory(machine);
    displayInventory(machine);
    State state = machine.getVendingMachineState();

    try {
      displayInventory(machine);
      state.clickOnInsertCoinButton();
      state = machine.getVendingMachineState();
      state.insertCoins(10);
      state.clickOnSelectItemsButton();
      state = machine.getVendingMachineState();
      state.selectItem(101, 1);
      state.selectItem(102, 1);
      state.clickOnDispenseItem();
      state = machine.getVendingMachineState();
      state.dispenseItems();

    } catch (Exception e) {
      System.err.println(e);
    }
  }

  static void fillInventory(VendingMachine machine) {
    int code = 101;
    Inventory inventory = machine.getInventory();
    for (int i = 0; i < machine.getInventorySize() / 4; i++) {
      inventory.setItem(code++, new Item(ItemType.COKE, 5), 1);
    }
    for (int i = machine.getInventorySize() / 4; i < 2 * machine.getInventorySize() / 4; i++) {
      inventory.setItem(code++, new Item(ItemType.JUICE, 7), 1);
    }
    for (int i = 2 * machine.getInventorySize() / 4; i < 3 * machine.getInventorySize() / 4; i++) {
      inventory.setItem(code++, new Item(ItemType.PEPSI, 6), 1);
    }
    for (int i = 3 * machine.getInventorySize() / 4; i < machine.getInventorySize(); i++) {
      inventory.setItem(code++, new Item(ItemType.SODA, 3), 1);
    }
  }

  static void displayInventory(VendingMachine machine) {
    Inventory inventory = machine.getInventory();

    ItemShelf[] shelves = inventory.getInventoryShelves();
    for (ItemShelf shelf : shelves) {
      System.out.println(shelf);
    }
  }
}
