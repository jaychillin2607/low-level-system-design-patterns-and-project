package model.state.impl;

import machine.VendingMachine;
import model.state.State;

public class IdleState extends State {

  public IdleState(VendingMachine vendingMachine) {
    super(vendingMachine);
  }

  @Override
  public void clickOnInsertCoinButton() throws Exception {
    System.out.println("clicked on insert coin button");
    vendingMachine.setVendingMachineState(new HasMoneyState(vendingMachine));
  }

  @Override
  public void insertCoins(int amount) throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void cancel() throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void refundAll() throws Exception {
    throw new Exception("function not implemented!");
  }

  @Override
  public void clickOnSelectItemsButton() throws Exception {
    throw new Exception("function not implemented!");
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