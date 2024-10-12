package mydocuments;

public interface documentLibrary {
  public boolean storeDocument(String documentName, String documentData);

  public String getDocument(String documentName);

  public String deleteDocument(String documentName);
}