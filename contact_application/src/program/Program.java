package program;

import contacts.Contact;
import contacts.BusinessContact;
import contacts.PersonalContact;
import helpers.Relationship;
import io.ContactsIO;

/**
 *This class Program interacts with the Contact application and the Scanner-read file provided by Josh Archer
 *@author Patrick Luong
 *@version 1.0
 */
public class Program {

    private static String fname;
    private static String lname;
    private static String phoneNumber;

    /**
     * This starts the program and calls the menu
     * @param args standard
     */
    public static void main(String[] args) {

        System.out.println(

                "Welcome to my Contacts Application\n" +
                        "**********************************\n"

        );

        getMenu();

    }

    /**
     * This is the menu for options to create and save personal and business contacts
     * and for options to print their respective iD cards
     */
    private static void getMenu() {

        int choiceMenu;

        //menu options to create and print iD cards
        do {
            System.out.println(
                    "1: New Personal Contact\n" +
                            "2: New Business Contact\n" +
                            "3: Print ID Cards\n" +
                            "4: Print Personal ID Cards\n" +
                            "5: Print Business ID Cards\n" +
                            "6: Clear contacts\n" +
                            "7: Exit\n"
            );

            choiceMenu = io.Console.readInt("");

            if (choiceMenu == 1) {

                newPersonalContact();

            } else if (choiceMenu == 2) {

                newBusinessContact();

            } else if (choiceMenu == 3) {

                printIdCard();

            }else if (choiceMenu == 4) {

                printPersonalIdCard();
            }
            else if (choiceMenu == 5){
                printBusinessIdCard();
            }
            else if(choiceMenu == 6){

                clearContacts();
            }
            else if(choiceMenu == 7){

                System.out.println("Have a nice day!");
            }
            else{
                System.out.println("Please enter a valid choice");
                getMenu();
            }

        }while (choiceMenu != 7) ;

    }

    /**
     * this method creates a new personal contact and saves into a text file
     */
    private static void newPersonalContact(){

        //get string values for firstname, lastname, and phone number
        fname = io.Console.readString("Enter first name: ");
        lname = io.Console.readString("Enter last name: ");
        phoneNumber = io.Console.readString("Enter phone number: ");

        String relationship = io.Console.readString("Enter relationship" +
                "(FRIEND, FAMILY, ACQUAINTANCE): ");
        String favorite = io.Console.readString("Enter favorite status (true, false): ");

        //instantiating contact to save to PersonalContact cast Enum and boolean to string values
        Contact newPersonalContact = new PersonalContact(fname, lname, phoneNumber,
                Relationship.valueOf(relationship), Boolean.parseBoolean(favorite));

        //saves contact into a text file
        ContactsIO.save(newPersonalContact);

    }

    /**
     * this method creates a new business contact and saves into a text file
     */
    private static void newBusinessContact(){

        fname = io.Console.readString("Enter first name: ");
        lname = io.Console.readString("Enter last name: ");
        phoneNumber = io.Console.readString("Enter phone number: ");
        String business = io.Console.readString("Enter Business name: ");

        //instantiating contact to save to BusinessContact
        Contact newBusinessContact = new BusinessContact(fname, lname, phoneNumber, business);

        //saves contact into a text file
        ContactsIO.save(newBusinessContact);

    }

    /**
     * this method prints out both iD cards
     */
    private static void printIdCard(){

        //new abstract Contact[] contacts stores ContactsIO.load()
        //load() instantiates PersonalContact and BusinessContact from text string
        Contact[] contacts = ContactsIO.load();

        //For-each loop, variable now traverses through contacts invokes/prints both iD card
        for (Contact now : contacts) {

            System.out.println(now.generateIdCard());
        }

    }

    /**
     * this method prints the personal iD card
     */
    private static void printPersonalIdCard(){

        Contact[] contacts = ContactsIO.load();

        //For-each loop, variable now traverses through contacts &
        //invokes/prints in the instanceof PersonalContact Id card
        for (Contact now : contacts) {

            if (now instanceof PersonalContact) {
                System.out.println(now.generateIdCard() + "\n");
            }

        }

    }

    /**
     * this method prints the business iD card
     */
    private static void printBusinessIdCard(){

        Contact[] contacts = ContactsIO.load();

        //For-each loop, variable now traverses through contacts &
        //invokes/prints in the instanceof BusinessContact Id card
        for (Contact now : contacts) {

            if (now instanceof BusinessContact) {
                System.out.println(now.generateIdCard() + "\n");
            }

        }

    }

    /**
     * this method clears the contacts from the text FILE
     */
    private static void clearContacts(){

        ContactsIO.clearContacts();

    }


}

