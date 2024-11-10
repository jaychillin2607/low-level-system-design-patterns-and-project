package caretaker;

import java.util.Stack;

import memento.*;
import originator.Editor;

public class Caretaker {
  private Stack<Memento> changes;
  Editor editor;

  public Caretaker(Editor editor) {
    changes = new Stack<>();
    this.editor = editor;
  }

  public void saveBackup() {
    changes.push(editor.saveBackup());
  }

  public boolean undo() {
    boolean res = false;

    if (res = !changes.isEmpty()) {
      changes.pop().restore();
    }

    return res;
  }
}
