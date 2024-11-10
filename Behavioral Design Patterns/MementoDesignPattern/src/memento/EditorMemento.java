package memento;

import originator.Editor;

public class EditorMemento implements Memento {
  Editor editor;
  private String content;
  private int curX, curY;
  private int scroll;

  public EditorMemento(Editor editor, String content, int curX, int curY, int scroll) {
    this.editor = editor;
    this.content = content;
    this.curX = curX;
    this.curY = curY;
    this.scroll = scroll;
  }

  @Override
  public void restore() {
    editor.setContent(content);
    editor.setCursor(curX, curY);
    editor.setScroll(scroll);
  }
}
