package S08ArraysListsBoxingL98_121.l107_110Challenge;

/**
 * Created by dev on 28/08/15.
 */
public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // static so we dont have to instantiate it
    public static Contact createContact(String name, String phoneNumber) {
        //calls the constructor
        return new Contact(name, phoneNumber);
    }
}
