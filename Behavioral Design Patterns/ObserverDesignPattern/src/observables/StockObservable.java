package observables;

import observers.StockObserver;

public interface StockObservable {
  public void add(StockObserver observer);

  public void remove(StockObserver observer);

  public void notifyObservers();

  public void addStock(int stock);

  public int getStock();
}