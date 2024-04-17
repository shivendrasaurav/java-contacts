import java.util.List;

public interface Contacts{
    //getters and setters for contact information??
    String getName();
    void setName();

    //not gonna lie, this is similar to what I would do in a react app. look up useState hook if you want
    List<String> getEmailIds();
    void addEmailId(String emailId);
    void removeEmailId(String emailId);

    //copy the same thing for phone numbers as its gonna be a list of string as well
    List<String> getPhoneNumbers();
    void addPhoneNumber(String phoneNumber);
    void removePhoneNumber(String phoneNumber);

    //finally a string of location. I originally planned for a photo as well, but I don't want to deal with rendering an image in terminal
    String getLocation();
    void setLocation(String location);

    //methods now?
    void addContact(Contact contact);

    //actually I don't know this, but can we function overloading in an interface? let's see how many errors we throw
    //another thing, I know we can do for items in list, but rather, should I mark first phone number as primary and that should only be used for searching? I don't know, the only thing this will do it make the data structures I use more complex
    Contact findContact(String name);
    Contact viewContact(String name);

    //on second thought, both of these should return a true or a false, so let's return integer atleast?
    //oh or rather, this is an interface, so I don't really have to do anything right now, I can worry about this when I'm implementing it's class. Is that it?
    void editContact(Contact contact);
    void deleteContact(String name);

    //just now I some "more" things about package manager and all. Right now I will go with the default package. Because I should be able to perhaps repackage everything at a later point of time as well? Right now just save.

}