import objects.*;
import game.*;

public class Main {
  public static void main(String[] args) {
    int humanRobotCount = 10;
    int animalRobotCount = 10;
    int x = 10, y = 1;
    Sprites data = new Sprites();

    Game game = new Game();
    for (int i = 0; i < humanRobotCount; i++) {
      game.addRobot(RobotType.HUMANOID, data, x - i, y + i);
    }

    x = x ^ y;
    y = x ^ y;
    x = x ^ y;

    for (int i = 0; i < animalRobotCount; i++){
      game.addRobot(RobotType.ANIMATRONIC, data, x+i, y - i);
    }
  }
}
