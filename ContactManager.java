package junitinterface;

import java.util.HashMap;
import java.util.Map;

public class ContactManager implements ContactDetails {
    Map<String, Contacts> c;

    public ContactManager() {
        c = new HashMap<>();
    }

    @Override
    public boolean addContact(String fName, String lName, String number) {
        if (fName == null || fName.isEmpty() || 
            lName == null || lName.isEmpty() || 
            number == null || number.length() != 10 || !isValidPhoneNumber(number) || 
            c.containsKey(fName)) {
            return false;
        }
        c.put(fName, new Contacts(fName, lName, number));
        return true;
    }

    @Override
    public boolean deleteContact(String firstName) {
        return c.remove(firstName) != null;
    }

    @Override
    public boolean updateContact(String fName, String number) {
        if (!c.containsKey(fName) || number == null || number.length() != 10) {
            return false;
        }
        c.get(fName).setPhone(number);
        return true;
    }

    @Override
    public boolean viewContact(String fName) {
        Contacts contact = c.get(fName);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }
        System.out.println("First Name: " + contact.getFirstName());
        System.out.println("Last Name: " + contact.getLastName());
        System.out.println("Phone: " + contact.getPhone());
        return true;
    }
    private boolean isValidPhoneNumber(String number) {
        if (number == null || number.length() != 10) {
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
