package tests;

import contacts.BusinessContact;
import contacts.Contact;
import contacts.PersonalContact;
import helpers.Relationship;

/**
 * this class is to test the superclass Contact and its derivatives PersonalContact
 * and BusinessContact
 * @author Patrick Luong
 * @version 1.0
 */
public class TestContact {

    /**
     * main method to test Contact variable and instantiating abstract method generateIdCard
     * along with toString
     * @param args standard
     */
    public static void main(String[] args) {

        //new abstract Contact invokes name instantiating Business and Personal contacts
        Contact montague = new BusinessContact("Montague","Rielly",
                "999-888-7777", "Microsoft");

        Contact andreea = new PersonalContact("Andreea", "Reilly",
                "999-888-777", Relationship.ACQUAINTANCE, true);

        Contact nancy = new PersonalContact("Nancy","Kirkpatrick",
                "444-888-6666",Relationship.FAMILY, true);

        Contact pat = new PersonalContact("pat","luong",
                "2537979556",Relationship.FRIEND,false);

        //Test call for abstract method generateIdCard
        System.out.println(montague.generateIdCard());
        System.out.println(andreea.generateIdCard());
        System.out.println(nancy.generateIdCard());
        System.out.println(pat.generateIdCard());

        //Test call for appropriate toString Override
        System.out.println(pat.toString());
        System.out.println(montague.toString());
        System.out.println(andreea.toString());

        /*
        Contact[] contacts = {montague, andreea, nancy, pat};
        example of what we can do with Class[] when sharing same parent
         */

    }

}
