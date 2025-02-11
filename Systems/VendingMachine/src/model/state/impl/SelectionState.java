package model.state.impl;

import machine.VendingMachine;
import model.state.State;
import model.SelectedItem;

public class SelectionState extends State {
  public SelectionState(VendingMachine vendingMachine) {
    super(vendingMachine);
  }

  @Override
  public void clickOnInsertCoinButton() throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void insertCoins(int amount) throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void cancel() throws Exception {
    System.out.println("cancelling!");
    refundAll();

    vendingMachine.getCart().clear();
    vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
    System.out.println("state changed to Idle");
  }

  @Override
  public void refundAll() throws Exception {
    if (vendingMachine.getCurrentAmount() != 0) {
      System.out.printf("collect your amount %d\n", vendingMachine.getCurrentAmount());
      vendingMachine.setCurrentAmount(0);
    }
  }

  @Override
  public void clickOnSelectItemsButton() throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void selectItem(int code, int qty) throws Exception {
    vendingMachine.addSelectedItemToCart(new SelectedItem(code, qty));
    System.out.println("item added to the cart!");
  }

  @Override
  public void getChange() throws Exception {
    int currentAmount = vendingMachine.getCurrentAmount();
    int cost = vendingMachine.getCartCost();
    if (cost > currentAmount) {
      System.out.println("not enough money!");
      refundAll();
    } else if (cost < currentAmount) {
      System.out.printf("collect your change %d\n", currentAmount - cost);
      vendingMachine.setCurrentAmount(0);
    }
  }

  @Override
  public void clickOnDispenseItem() throws Exception {
    System.out.println("clicked on dispense item state");
    getChange();

    vendingMachine.setVendingMachineState(new DispenseState(vendingMachine));
  }

  @Override
  public void dispenseItems() throws Exception {
    throw new Exception("function not implemented!");
  }
}