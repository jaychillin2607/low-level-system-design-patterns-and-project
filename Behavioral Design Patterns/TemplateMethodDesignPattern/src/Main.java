import java.util.Scanner;
import linuxSetup.LinuxSetup;
import systemSetup.SystemSetup;
import windowsSetup.WindowsSetup;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Choose any one OS to setup(default: Linux):\n1. Windows\n2. Linux\n");
    int choice = scan.nextInt();
    String OSName;

    switch (choice) {
      case 1:
        OSName = "windows";
        break;
      default:
        OSName = "linux";
    }

    SystemSetup setup = null;
    if (choice == 1) {
      setup = new WindowsSetup(OSName);
    } else {
      setup = new LinuxSetup(OSName);
    }

    setup.setupFirstBoot();
  }
}
