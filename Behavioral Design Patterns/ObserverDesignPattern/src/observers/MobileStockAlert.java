package observers;

import observables.StockObservable;

public class MobileStockAlert implements StockObserver {
  String mobileNumber;
  StockObservable observable;

  public MobileStockAlert(String mobileNumber, StockObservable observable) {
    this.mobileNumber = mobileNumber;
    this.observable = observable;
  }

  @Override
  public void update() {
    mobileAlert(this.mobileNumber, "Iphones are in re-stocked hurry!!");
  }

  public void mobileAlert(String mobileNumber, String msg) {
    System.out.println("To: " + mobileNumber + "\n" + msg);
  }
}