import vendingMachine.*;
import vendingMachineState.*;

public class Main {
  public static void main(String[] args) {
    VendingMachine vm = new VendingMachine(9);
    try {
      System.out.println("Filling up the Vending Machine ...");
      vm.fillUpMachine();
      VendingMachineState state = vm.getState();
      state.pressInsertCoinButton();
      System.out.println(1);
      vm.displayInventory();

      state = vm.getState();

      state.insertCoin(Coin.QUARTER);
      state.insertCoin(Coin.QUARTER);

      state.selectProductButton();

      state = vm.getState();

      vm.displayInventory();

      state.chooseProduct();

      state.dispenseProductButton();

      state = vm.getState();

      state.productDispensing();

    } catch (Exception e) {
      System.out.println("Try again ...");
      vm.displayInventory();
    }

  }

}