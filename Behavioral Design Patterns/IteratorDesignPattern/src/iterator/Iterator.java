package iterator;

import aggregator.Tree;

public interface Iterator {

  public Tree next();

  public boolean hasNext();

}
