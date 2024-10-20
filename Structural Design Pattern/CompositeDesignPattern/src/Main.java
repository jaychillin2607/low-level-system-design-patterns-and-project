
import filesystem.Directory;
import filesystem.File;
import filesystem.FileSystem;

class Main {
  public static void main(String[] args) {
    // root file
    Directory root = new Directory("home");
    FileSystem temp = new File(".temp");
    root.add(temp);

    Directory programs = new Directory("programs");
    FileSystem vscode = new File("vscode");
    FileSystem chrome = new File("chrome");
    programs.add(vscode);
    programs.add(chrome);
    root.add(programs);

    root.ls();
  }
}
