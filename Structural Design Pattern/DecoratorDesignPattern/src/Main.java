import datafile.*;
import operations.Encrypt;

public class Main {
  public static void main(String[] args) {
    String data = "Hello world!";
    DataFile file1 = new SimpleTextFile();
    file1.writeData(data);
    System.out.println(file1.readData());

    DataFile file2 = new SimpleTextFile();
    file2 = new Encrypt(file2);
    file2.writeData(data);
    System.out.printf("encoded data: %s\n", file2.getData());
    System.out.printf("decoded data: %s\n", file2.readData());
  }
}