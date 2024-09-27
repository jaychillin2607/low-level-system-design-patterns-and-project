import observables.*;
import observers.*;

public class Main {
  public static void main(String[] args) {
    IphoneStockObservable iphoneObservable = new IphoneStockObservable(0);

    EmailStockAlert esa = new EmailStockAlert("j@java.com", iphoneObservable);
    MobileStockAlert msa = new MobileStockAlert("s@java.com", iphoneObservable);

    iphoneObservable.add(esa);
    iphoneObservable.add(msa);

    // let's restock
    iphoneObservable.addStock(10);
  }

}
