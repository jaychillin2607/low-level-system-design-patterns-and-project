package operations;

import datafile.DataFile;

class FileDecorator implements DataFile {
  DataFile wrapee;

  FileDecorator(DataFile wrapee) {
    this.wrapee = wrapee;
  }

  @Override
  public String readData() {
    return this.wrapee.readData();
  }

  @Override
  public void writeData(String data) {
    this.wrapee.writeData(data);
  }

  @Override
  public String getData() {
    return this.wrapee.getData();
  }
}