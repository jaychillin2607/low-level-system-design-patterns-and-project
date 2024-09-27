package observables;

import java.util.*;
import observers.StockObserver;

public class IphoneStockObservable implements StockObservable {
  List<StockObserver> observers;
  int stock = 0;

  public IphoneStockObservable(int stock) {
    this.stock = stock;
    this.observers = new ArrayList<StockObserver>();
  }

  @Override
  public void add(StockObserver observer) {
    observers.add(observer);
  }

  public void remove(StockObserver observer) {
    observers.remove(observer);
  }

  public void addStock(int stock) {
    if (this.stock == 0) {
      this.notifyObservers();
    }
    this.stock += stock;
  }

  public int getStock() {
    return this.stock;
  }

  public void notifyObservers() {
    for (StockObserver observer : observers) {
      observer.update();
    }
  }
}