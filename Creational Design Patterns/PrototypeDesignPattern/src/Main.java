import prototype.Circle;

public class Main{
  public static void main(String [] args){
    Circle obj = new Circle(7, "red");
    System.out.println(obj);
    Circle anotherObj = obj.clone();
    System.err.println(anotherObj);
  }
}
