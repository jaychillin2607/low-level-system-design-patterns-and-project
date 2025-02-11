package model.state.impl;

import machine.VendingMachine;
import model.state.State;

public class HasMoneyState extends State {

  public HasMoneyState(VendingMachine vendingMachine) {
    super(vendingMachine);
  }

  @Override
  public void clickOnInsertCoinButton() throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void insertCoins(int amount) throws Exception {
    vendingMachine.setCurrentAmount(amount);
  }

  @Override
  public void cancel() throws Exception {
    System.out.println("cancelling!");
    refundAll();

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
    System.out.println("clicked select items button");
    vendingMachine.setVendingMachineState(new SelectionState(vendingMachine));
  }

  @Override
  public void selectItem(int code, int qty) throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void getChange() throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void clickOnDispenseItem() throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void dispenseItems() throws Exception {
    throw new Exception("function not implemented!");
  }
}