package product;

public class HTMLButton implements Button {
  @Override
  public void render() {
    System.out.println("HTML Button is rendered!");
  }

  @Override
  public void onClick() {
    System.out.println("You clicked HTML button!");
  }
}