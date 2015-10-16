package Contact;

/**
 *
 * @author Ben Reining
 * @version 10/13/15
 * A class that creates names, e-mails, and phone numbers.
 * Once these are determined, it compares them to each other.
 */
public abstract class Contact implements Comparable {

    private String name;
    private String phoneNumber;
    private String eMail;

    /**
     * Constructor
     *
     * @param name
     * @param phoneNumber
     * @param eMail
     */
    public Contact(String name, String phoneNumber, String eMail) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }

    /**
     *Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *Getter
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *Getter
     * @return eMail
     */
    public String getEMail() {
        return eMail;
    }

    /**
     *Setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Setter
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *Setter
     * @param eMail
     */
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     *toString
     * @return a toString
     */
    @Override
    public String toString() {
        return "Name: " + name + " Phone Number: " + phoneNumber + " E-mail: " + eMail;
    }

    /**
     *
     * @param obj
     * @return integer that determines the placement
     */
    public int compareTo(Contact obj) {
        
        int comparison = name.compareTo(obj.name);
        if (comparison != 0)
            return comparison;
        else 
        return 0;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Contact me = new Contact("Charley", "250-3918", "csheaffe@unca.edu") {

            @Override
            public int compareTo(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        System.out.println(me);
    }
}
