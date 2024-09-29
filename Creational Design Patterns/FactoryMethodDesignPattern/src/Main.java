import javax.swing.text.html.HTML;

import factory.*;
import product.*;

class Main {
  public static void main(String[] args) {
    // Factory
    Dialog winDialog = new WindowsDialog();
    Button winButton = winDialog.render();

    Dialog htmlDialog = new HTMLDialog();
    Button htmlButton = htmlDialog.render();
  }
}
