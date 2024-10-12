package mydocuments;

import java.util.*;

public class MyDocumentLibrary implements documentLibrary {
  private static HashMap<String, String> documents;

  public MyDocumentLibrary() {
    if (documents == null) {
      documents = new HashMap<>();
    }
  }

  @Override
  public boolean storeDocument(String documentName, String documentData) {

    if (documents.containsKey(documentName)) {
      return false;
    }

    documents.put(documentName, documentData);

    return true;
  }

  @Override
  public String getDocument(String documentName) {
    String data = documents.get(documentName);
    return data;
  }

  @Override
  public String deleteDocument(String documentName) {
    String res = documents.remove(documentName);

    return res;
  }
}