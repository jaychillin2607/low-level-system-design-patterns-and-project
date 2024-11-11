import adapter.SquarePegAdapter;
import client.SquarePeg;
import service.RoundHole;
import service.RoundPeg;

class Main {
  public static void main(String[] args) {
    // create round hole
    RoundHole rh = new RoundHole(7.5);

    // create round peg
    RoundPeg rp = new RoundPeg(7);
    System.out.printf("Does round peg fits?: %b\n", rh.doesItFit(rp));

    // create square peg
    SquarePeg ssp = new SquarePeg(10);
    SquarePeg lsp = new SquarePeg(11);

    // adapter
    SquarePegAdapter spa = new SquarePegAdapter();
    spa.setSquarePeg(ssp);
    System.out.printf("Does small square peg fits?: %B\n", rh.doesItFit(spa));
    spa.setSquarePeg(lsp);
    System.out.printf("Does large square peg fits?: %B\n", rh.doesItFit(spa));
  }
}
