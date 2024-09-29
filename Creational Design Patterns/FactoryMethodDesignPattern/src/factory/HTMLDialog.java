package factory;

import product.HTMLButton;

public class HTMLDialog extends Dialog {
  @Override
  protected HTMLButton createButton() {
    return new HTMLButton();
  }
}