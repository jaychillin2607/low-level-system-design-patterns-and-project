package model.state.impl;

import machine.VendingMachine;
import model.state.State;

public class DispenseState extends State {

  public DispenseState(VendingMachine vendingMachine) {
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
    vendingMachine.processTransaction();
    System.out.println("collect your order!");
    System.out.println(vendingMachine.getCart());
    vendingMachine.getCart().clear();
    vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
  }
}