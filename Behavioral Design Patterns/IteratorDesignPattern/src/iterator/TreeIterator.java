package iterator;

import java.util.ArrayList;

import aggregator.Tree;

public class TreeIterator implements Iterator {

  private ArrayList<Tree> trees;
  private int index = 0;

  public TreeIterator(ArrayList<Tree> al) {
    trees = al;
  }

  @Override
  public boolean hasNext() {
    return index < trees.size();
  }

  @Override
  public Tree next() {
    if (hasNext()) {
      return trees.get(index++);
    }
    return null;
  }

}
