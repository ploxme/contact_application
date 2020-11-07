package contacts;

/**
 * This Object returns a business iD card with their business name
 * @author Patrick Luong
 * @version 1.0

 */
public class BusinessContact extends Contact {

    private String business;

    /**
     * creates a business contact constructor
     * @param fname first name
     * @param lname last name
     * @param phoneNumber phone number
     * @param business business name
     */
    public BusinessContact(String fname, String lname,
                           String phoneNumber, String business ){

        //constructor from Contact
        super(fname, lname, phoneNumber);

        //receive getter from Contact
        this.business = business;

    }

    /**
     * method to satisfy implementation of abstract method generateIdCard from Contact
     * prints a string version of Business contact's iD card
     * @return business iD card
     */
    @Override
    public String generateIdCard() {
        return
                "+-------------------------------------+\n" +
                "| First: " + getFname() + "\n" +
                "| Last: " + getLname() + "\n" +
                "| Phone: #" + getPhoneNumber() + "\n" +
                "| Business: " + business + "\n" +
                "+-------------------------------------+";
    }

    /**
     * Overrides Contact toString with PersonalContact toString
     * used proper format firstname,lastname,phone number to interact with ContactIO
     * @return BusinessContact toString
     */
    @Override
    public String toString() {
        return getFname()+","+getLname()+","+getPhoneNumber()+","+
                business;
    }

}



