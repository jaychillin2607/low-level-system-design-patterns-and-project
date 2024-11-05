package objects;

import java.util.*;

public class RobotFactory {
  static Map<RobotType, IRobot> robots = new HashMap<>();

  public static IRobot getRobot(RobotType type, Sprites data){
    IRobot product;
    if ((product = robots.get(type)) == null){
      if (type == RobotType.HUMANOID){
        product = new HumanRobot(type, data);
      } else {
        product = new AnimalRobot(type, data);
      }
      robots.put(type, product);
    }
    return product;
  }

}
