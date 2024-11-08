import iterator.*;
import aggregator.*;

public class Main {
  public static void main(String[] args) {
    Forest forest = new Forest();
    forest.addTree(new Tree("pine"));
    forest.addTree(new Tree("cedar"));
    forest.addTree(new Tree("royal poinciana"));
    forest.addTree(new Tree("conifer"));

    Iterator itr = forest.getIterator();

    while (itr.hasNext()) {
      System.out.println(itr.next());
    }
  }
}
