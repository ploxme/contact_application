package io;

import contacts.BusinessContact;
import contacts.Contact;
import contacts.PersonalContact;
import helpers.Relationship;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class lets you read and write Contact objects
 * to a text file.
 *
 * DO NOT ALTER THIS FILE!
 *
 * @author Josh Archer
 * @version 1.0
 */
public class ContactsIO
{
    private static final String FILE = "contacts/contacts.txt";

    /**
     * Saves a single Contact object to the end of the "contacts/contacts.txt" file.
     * @param contact the contact to save to the file
     */
    public static void save(Contact contact)
    {
        //open the file in append mode
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILE, true)))
        {
            writer.println(contact);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }

    /**
     * Loads all contacts found in "contacts/contacts.txt" to an array and returns it.
     * @return an array of Contact objects
     */
    public static Contact[] load()
    {
        //prepare my return type
        Contact[] contacts = new Contact[lines()];

        try (Scanner reader = new Scanner(new FileInputStream(FILE)))
        {
            //read each contact in a line within the file
            int index = 0;
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 4) //business contact
                {
                    contacts[index] = new BusinessContact(
                        parts[0],
                        parts[1],
                        parts[2],
                        parts[3]);
                }
                else //length == 5 (personal contact)
                {
                    contacts[index] = new PersonalContact(
                        parts[0],
                        parts[1],
                        parts[2],
                        Relationship.valueOf(parts[3]),
                        Boolean.parseBoolean(parts[4]));
                }
                index++;
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
        return contacts;
    }

    /**
     * Wipes all Contact objects that have been saved previously from the
     * "contacts/contacts.txt" file.
     */
    public static void clearContacts()
    {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(FILE)))
        {
            //do nothing (just wipe the file)
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }

    //counts the lines in our input file (a helper method)
    private static int lines()
    {
        int count = 0;
        try (Scanner reader = new Scanner(new FileInputStream(FILE)))
        {
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                if (!line.equals(""))
                {
                    count++;
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error reading from file: " + ex.getMessage());
        }
        return count;
    }
}
