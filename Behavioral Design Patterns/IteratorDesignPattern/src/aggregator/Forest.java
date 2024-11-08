package aggregator;

import java.util.ArrayList;

import iterator.*;

public class Forest implements Aggregator {

  private ArrayList<Tree> trees;

  public Forest() {
    trees = new ArrayList<>();
  }

  public void addTree(Tree tree) {
    trees.add(tree);
  }

  @Override
  public Iterator getIterator() {
    return new TreeIterator(trees);
  }

}
