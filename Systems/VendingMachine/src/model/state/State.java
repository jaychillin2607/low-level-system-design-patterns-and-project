package model.state;

public interface State {
  void clickOnInsertCoinButton();

  void insertCoins(int amount);

  void cancel();

  void clickOnSelectItemsButton();

  void selectItem(int code);

  void getChange();

  void clickOnDispenseItem();

}