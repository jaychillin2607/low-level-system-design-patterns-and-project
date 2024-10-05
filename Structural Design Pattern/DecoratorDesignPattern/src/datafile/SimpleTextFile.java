package datafile;

public class SimpleTextFile implements DataFile {
  String data = "";

  @Override
  public String readData() {
    return this.data;
  }

  @Override
  public void writeData(String data) {
    this.data = data;
  }

  @Override
  public String getData() {
    return this.data;
  }
}