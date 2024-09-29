package factory;

import product.Button;

abstract public class Dialog {
  abstract protected Button createButton();

  public Button render() {
    Button button = createButton();
    button.render();
    button.onClick();
    return button;
  }
}