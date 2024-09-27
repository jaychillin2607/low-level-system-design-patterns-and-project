package observers;

import observables.StockObservable;

public class EmailStockAlert implements StockObserver {
  String email;
  StockObservable observable;

  public EmailStockAlert(String email, StockObservable observable) {
    this.email = email;
    this.observable = observable;
  }

  @Override
  public void update() {
    sendEmail(this.email, "Iphones are back in stock hurry!!");
  }

  public void sendEmail(String emailId, String msg) {
    System.out.println("To: " + emailId + "\n" + msg);
  }
}
