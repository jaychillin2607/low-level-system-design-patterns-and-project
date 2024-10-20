package filesystem;

import java.util.ArrayList;

public class Directory implements FileSystem {
  private final String name;
  private final ArrayList<FileSystem> contents;

  public Directory(String name) {
    this.name = name;
    this.contents = new ArrayList<>();
  }

  public void add(FileSystem child) {
    this.contents.add(child);
  }

  @Override
  public void ls() {
    System.out.println("directory: " + this.name + "/");
    for (FileSystem f : contents)
      f.ls();
  }

}