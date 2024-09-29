package product;

public class WindowsButton implements Button {
  @Override
  public void render() {
    System.out.println("Windows Button is rendered!");
  }

  @Override
  public void onClick() {
    System.out.println("You clicked windows button!");
  }
}