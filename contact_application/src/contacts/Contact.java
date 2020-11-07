package contacts;

/**
 * This is the Parent class of PersonalContact and BusinessContact
 * and interacts with the ConsoleIO class
 * to generate iD cards
 * @author Patrick Luong
 * @version 1.0

 */
public abstract class Contact {

    private String fname;
    private String lname;
    private String phoneNumber;

    /**
     * "Default" constructor that is parameterized
     * @param fname first name
     * @param lname last name
     * @param phoneNumber phone number
     */
    public Contact(String fname, String lname, String phoneNumber) {

        this.fname = fname;
        this.lname = lname;
        this.phoneNumber = phoneNumber;
    }

    /**
     * abstract method that is implemented in child class's PersonalContact and BusinessContact
     * @return idCard for PersonalContact and BusinessContact
     */
    public abstract String generateIdCard();


    /**
     * retrieves firstname - first string for super constructor
     * @return first name
     */
    public String getFname() {

        return fname;
    }

    /**
     * retrieves lastname - 2nd string for super constructor
     * @return last name
     */
    public String getLname() {

        return lname;
    }

    /**
     * retrieves phone number - 3rd string for super constructor
     * @return phone number
     */
    public String getPhoneNumber() {

        return phoneNumber;

    }

    /**
     * return generic string, the string has to read fname,lname,phonenumber
     * in order for ContactsIO to interact with Contact class properly
     * @return generic toString of contact
     */
    @Override
    public String toString() {

        return fname + "," + lname + "," + phoneNumber;

    }
}
