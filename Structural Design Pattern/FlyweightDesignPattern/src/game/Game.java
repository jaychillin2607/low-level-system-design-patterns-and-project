package game;

import java.util.ArrayList;

import objects.IRobot;
import objects.RobotFactory;
import objects.RobotType;
import objects.Sprites;

public class Game{
  private ArrayList<IRobot> gameObjects;

  public Game(){
    gameObjects = new ArrayList<IRobot>();
  }

  public void addRobot(RobotType type, Sprites data, int x, int y){
    IRobot object = RobotFactory.getRobot(type, data);
    gameObjects.add(object);
    object.render(x, y);
  }
}
