package factory;

import product.WindowsButton;

public class WindowsDialog extends Dialog {
  @Override
  protected WindowsButton createButton() {
    return new WindowsButton();
  }
}