package filesystem;

public class File implements FileSystem {
  private final String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public void ls() {
    System.out.println("filename: " + this.name);
  }

}