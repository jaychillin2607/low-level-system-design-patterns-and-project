package operations;

import datafile.DataFile;

public class Encrypt extends FileDecorator {

  public Encrypt(DataFile wrapee) {
    super(wrapee);
  }

  public String encodeDecode(String str) {
    char arr[] = str.toCharArray();
    int l = 0, h = arr.length - 1;
    while (l < h) {
      char tmp = arr[l];
      arr[l] = arr[h];
      arr[h] = tmp;
      l++;
      h--;
    }
    return new String(arr);
  }

  @Override
  public String readData() {
    String data = this.encodeDecode(this.wrapee.readData());
    return data;
  }

  @Override
  public void writeData(String data) {
    data = this.encodeDecode(data);
    this.wrapee.writeData(data);
  }

  public String getData() {
    return this.wrapee.readData();
  }
}