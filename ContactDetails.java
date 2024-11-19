package junitinterface;

public interface ContactDetails {
    boolean addContact(String fName, String lName, String number);
    boolean deleteContact(String fName);
    boolean updateContact(String fName, String number);
    boolean viewContact(String fName);
}
