package contacts;

import helpers.Relationship;

/**
 * The class PersonalContact returns personal contacts
 * with a stylize personal favorite
 * @author Patrick Luong
 * @version 1.0

 */
public class PersonalContact extends Contact {

    private boolean favorite;
    private Relationship relationship;

    /**
     * creates a personal contact constructor
     * @param fname first name
     * @param lname last name
     * @param phoneNumber phone number
     * @param relationship relations to contact
     * @param favorite  to set as favorite on idCard
     */
    public PersonalContact(String fname, String lname, String phoneNumber,
                            Relationship relationship, boolean favorite) {

        //call Contact constructor
        super(fname, lname, phoneNumber);

        //receive getter from Contact
        this.relationship = relationship;
        this.favorite = favorite;

    }

    /**
     * method to satisfy implementation of abstract method generateIdCard from Contact
     * prints a string version of a Personal Contact iD card
     * @return PersonalContact iD card
     */
    @Override
    public String generateIdCard() {

        //prints Favorite if favorite is true
        if (favorite) {
            return
                    "+-------------------------------------+\n" +
                    "| First: " + getFname() + "\n" +
                    "| Last: " + getLname() + "\n" +
                    "| Phone: #" + getPhoneNumber() + "\n" +
                    "| Relationship: " + relationship.toString() + "\n" +
                    "| Favorite" + "\n" +
                    "+-------------------------------------+";
        }
        //disregard Faovrite is favorite is false
        else{
            return
                    "+-------------------------------------+\n" +
                    "| First: " + getFname() + "\n" +
                    "| Last: " + getLname() + "\n" +
                    "| Phone: #" + getPhoneNumber() + "\n" +
                    "| Relationship: " + relationship.toString() + "\n" +
                    "+-------------------------------------+";

        }
    }

    /**
     * Overrides Contact toString with PersonalContact toString
     * used proper format firstname,lastname,phone number to interact with ContactIO
     * @return toString for PersonalContact
     */
    @Override
    public String toString() {

        return getFname()+","+getLname()+","+getPhoneNumber()+","+
                relationship.toString()+","+favorite;

    }
}





