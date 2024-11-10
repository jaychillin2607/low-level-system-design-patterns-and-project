import originator.*;
import caretaker.*;

public class Main {
  public static void main(String[] args) {
    Editor editor = new Editor();
    Caretaker history = new Caretaker(editor);

    history.saveBackup();
    
    editor.setContent( "Hi how are you!");
    editor.setCursor(34, 2);
    editor.setScroll(10);

    System.out.println(editor);
    history.undo();
    System.out.println(editor);
  }
}
