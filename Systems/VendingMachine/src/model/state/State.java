package model.state;

import machine.VendingMachine;

public abstract class State {
  protected VendingMachine vendingMachine;

  public State(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  public abstract void clickOnInsertCoinButton() throws Exception;

  public abstract void insertCoins(int amount) throws Exception;

  public abstract void cancel() throws Exception;

  public abstract void clickOnSelectItemsButton() throws Exception;

  public abstract void selectItem(int code, int qty) throws Exception;

  public abstract void refundAll() throws Exception;

  public abstract void clickOnDispenseItem() throws Exception;

  public abstract void getChange() throws Exception;

  public abstract void dispenseItems() throws Exception;
}