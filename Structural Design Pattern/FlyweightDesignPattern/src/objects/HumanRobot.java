package objects;

public class HumanRobot implements IRobot {
  private RobotType type;
  private Sprites bitmapData;

  public HumanRobot(RobotType type, Sprites data) {
    this.type = type;
    this.bitmapData = data;
  }

  @Override
  public void fight() {
    System.out.println("Human robot starts firing shots!!");
  }

  @Override
  public void render(int x, int y) {
    System.err.printf("Human robot is rendered at (%d, %d)!\n", x, y);
  }

}
