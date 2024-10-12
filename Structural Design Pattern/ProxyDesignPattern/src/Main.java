import mydocuments.documentLibrary;
import proxydocumentlibrary.ProxyDocumentLibrary;

class Main {
  public static void main(String[] args) {

    documentLibrary userDocLib = new ProxyDocumentLibrary("USER");

    userDocLib.storeDocument("name.txt", "jay");
    System.out.println(userDocLib.getDocument("name.txt"));

    documentLibrary adminDocLib = new ProxyDocumentLibrary("ADMIN");

    adminDocLib.deleteDocument("name.txt");

    adminDocLib.getDocument("name.txt");
  }

}
