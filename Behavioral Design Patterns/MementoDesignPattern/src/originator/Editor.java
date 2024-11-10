package originator;

import memento.*;

public class Editor {
  private String content;
  private int curX, curY;
  private int scroll;

  public Editor() {
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setCursor(int x, int y) {
    curX = x;
    curY = y;
  }

  public void setScroll(int scroll) {
    this.scroll = scroll;
  }

  public Memento saveBackup() {
    return new EditorMemento(this, content, curX, curY, scroll);
  }

  @Override
  public String toString() {
    return content + " curX: " + curX + " curY: " + curY + " scroll: " + scroll;
  }
}
