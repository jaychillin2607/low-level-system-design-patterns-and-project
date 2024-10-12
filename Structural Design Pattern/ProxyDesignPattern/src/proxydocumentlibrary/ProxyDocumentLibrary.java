package proxydocumentlibrary;

import mydocuments.*;

public class ProxyDocumentLibrary implements documentLibrary {
  protected final MyDocumentLibrary documentLibrary;
  protected final String accessGroup;

  public ProxyDocumentLibrary(String group) {
    this.accessGroup = group;
    documentLibrary = new MyDocumentLibrary();
  }

  @Override
  public boolean storeDocument(String documentName, String documentData) {
    System.out.printf("storing file %s\n", documentName);
    boolean res = documentLibrary.storeDocument(documentName, documentData);

    if (!res)
      System.out.printf("%s couldn't be saved\n", documentName);
    else
      System.out.printf("%s stored successfully\n", documentName);
    return res;
  }

  @Override
  public String getDocument(String documentName) {
    String data = documentLibrary.getDocument(documentName);

    if (data == null)
      System.out.printf("file %s doesn't exist\n", documentName);

    return data;
  }

  @Override
  public String deleteDocument(String documentName) {
    if (!this.accessGroup.equals("ADMIN"))
      System.out.printf("group %s does not access to delete a document\n", this.accessGroup);

    String res = documentLibrary.deleteDocument(documentName);

    if (res == null)
      System.out.printf("no file with name %s\n", documentName);
    else
      System.out.printf("%s deleted successfully\n", documentName);

    return res;
  }

}