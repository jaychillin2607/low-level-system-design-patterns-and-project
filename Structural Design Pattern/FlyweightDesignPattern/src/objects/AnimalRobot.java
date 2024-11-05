package objects;

public class AnimalRobot implements IRobot {
  private RobotType type;
  private Sprites bitmapData;

  public AnimalRobot(RobotType type, Sprites data) {
    this.type = type;
    this.bitmapData = data;
  }

  @Override
  public void fight() {
    System.out.println("Animal robot runs to bite!!");
  }

  @Override
  public void render(int x, int y) {
    System.err.printf("Animal robot is rendered at (%d, %d)!\n", x, y);
  }
}
