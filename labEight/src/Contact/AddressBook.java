package Contact;

import java.util.Scanner;

/**
 *
 * @author Ben Reining
 * @version 10/13/15
 * A class that creates contacts by using the parameters from
 * the Contact class.
 *
 */
public class AddressBook {

    private static final int DEFAULTSIZE = 100;
    private Contact[] contactList;
    private int count;
    private Scanner in;

    /**
     *
     * @param size
     */
    public AddressBook(int size) {
        contactList = new Contact[size];
        count = 0;
        in = new Scanner(System.in);
    }

    public AddressBook() {
        this(DEFAULTSIZE);
    }

// This method can fail if the contact list is already full.
    /**
     *
     * @param newContact
     */
    public void addContact(Contact newContact) {
        contactList[count] = newContact;
        count++;
    }

    /**
     *
     * @param name
     * @param phoneNumber
     * @param eMail
     */
    public void addContact(String name, String phoneNumber, String eMail) {
        Contact newContact = new Contact(name, phoneNumber, eMail) {
        };
        addContact(newContact);
    }

    public void readContact() {
        System.out.print("Enter name: ");
        String name = in.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = in.nextLine();
        System.out.print("Enter e-mail: ");
        String eMail = in.nextLine();
        addContact(new Contact(name, phoneNumber, eMail) {
        });
    }

    /**
     *
     * @param name
     * @return null
     */
    public Contact findContact(String name) {
        int index = indexOf(name);
        if (index != -1) {
            return contactList[index];
        }

        return null;   // indicate name not in contact list
    }

    /**
     * Returns the index of the name location if found
     * @param name
     * @return i (The index of the name location)
     */
    private int indexOf(String name) {
        for (int i = 0; i < count; i++) {
            if (name.equals(contactList[i].getName())) {
                return i;
            }
        }

        return -1;   // indicate name not in contact list    
    }

    /**
     * Gets rid of the Contact of your choice.
     * @param name
     * @return person
     */
    public Contact removeContact(String name) {
        int index = indexOf(name);
        if (index == -1) {
            return null;
        }
        Contact person = contactList[index];
        for (int i = index; i < count; i++) {
            contactList[i] = contactList[i + 1];
        }
        count--;
        return person;
    }

    /**
     * Replaces the old Contact with a new one.
     * @param name
     * @param newName
     * @param newPhone
     * @param newEMail
     */
    public void updateContact(String name, String newName, String newPhone, String newEMail) {
        Contact person = findContact(name);
        if (person == null) {
            return;
        }
        person.setName(newName);
        person.setPhoneNumber(newPhone);
        person.setEMail(newEMail);
    }

    /**
     *
     * @param name
     * @param newName
     */
    public void updateName(String name, String newName) {
        Contact person = findContact(name);
        if (person == null) {
            return;
        }
        person.setName(newName);
    }

    /**
     *
     * @param name
     * @param newPhone
     */
    public void updatePhoneNumber(String name, String newPhone) {
        Contact person = findContact(name);
        if (person == null) {
            return;
        }
        person.setPhoneNumber(newPhone);
    }

    /**
     *
     * @param name
     * @param newEMail
     */
    public void updateEMail(String name, String newEMail) {
        Contact person = findContact(name);
        if (person == null) {
            return;
        }
        person.setEMail(newEMail);
    }

    /**
     *
     * @return toString
     */
    @Override
    public String toString() {
        StringBuilder display = new StringBuilder("");
        for (int i = 0; i < count; i++) {
            display.append(contactList[i].toString());
            display.append("\n");
        }
        return display.toString();
    }

    /**
     *
     * @param a []
     */
    public int insertion(int a[]) {
        for (int i = 1; i < a.length - 1; i++) {
            int current = a[i];
            for (int j = i - 1; j >= 0 && current < a[j]; j--) {
               // if (current < a[j])
                if (a[i].compareTo(a[j]) == 0){
                    return 0;
                }
                else if (a[i].compareTo(a[j]) < 0){
                    return -1;
                }
                else return 1;
 
                    
                //a[j + 1] = a[j];
                
                //current = a[j + 1];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        AddressBook myBook = new AddressBook(50);
        Contact bob = new Contact("Bob", "828-555-1212", "bob@here.org") {
        };
        Contact bill = new Contact("Bill", "828-555-2424", "bill@there.com") {
        };

        myBook.addContact(bob);
        myBook.addContact(bill);
        myBook.addContact("Jill", "828-555-3636", "jill@nowhere.edu");
        myBook.addContact("John", "828-555-3978", "john@uncad.edu");

        System.out.println(myBook.findContact("Jill"));
        System.out.println(myBook.findContact("Jane"));
        System.out.println(myBook);

        myBook.removeContact("Jill");
        System.out.println(myBook);

        myBook.addContact("Jill", "828-555-3636", "jill@nowhere.edu");
        myBook.updateContact("Jill", "Jan", "828-555-1234", "jan@hereandthere.org");
        System.out.println(myBook);
        System.out.println(myBook.findContact("Jan"));

        myBook.readContact();
        System.out.println(myBook);
    }
}