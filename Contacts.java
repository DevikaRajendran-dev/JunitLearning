package junitinterface;
public class Contacts{
    private String fName;
    private String lName;
    private String number;

    public Contacts(String fName, String lName, String number) {
        this.fName = fName;
        this.lName = lName;
        this.number = number;
    }

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public String getPhone() {
        return number;
    }

    public void setPhone(String number) {
        this.number = number;
    }

}
