//import java.util.List;

public interface Users{
    //getters and setters for user information??
    //String getName();
    //void setName();

    //not gonna lie, this is similar to what I would do in a react app. look up useState hook if you want
    //List<String> getEmailIds();
    //void addEmailId(String emailId);
    //void removeEmailId(String emailId);

    //copy the same thing for phone numbers as its gonna be a list of string as well
    //List<String> getPhoneNumbers();
    //void addPhoneNumber(String phoneNumber);
    //void removePhoneNumber(String phoneNumber);

    //finally a string of location. I originally planned for a photo as well, but I don't want to deal with rendering an image in terminal
    //String getLocation();
    //void setLocation(String location);

    //methods now?
    void addUser(User user);

    //these methods need to change a little bit because we want to implement a login here instead of find?? Or should I just add login as a seperate method whilst keeping these as is? Searching for users might be required as well? who knows??

    User loginUser(String username, String password);
    //makes sense makes sense, type safety and all, ehhhh

    User findUser(String name);
    User viewUser(String name);

    //on second thought, both of these should return a true or a false, so let's return integer atleast?
    //oh or rather, this is an interface, so I don't really have to do anything right now, I can worry about this when I'm implementing it's class. Is that it?
    void editUser(User originalUser, User updatedUser);
    void deleteUser(String name);

    //just now I some "more" things about package manager and all. Right now I will go with the default package. Because I should be able to perhaps repackage everything at a later point of time as well? Right now just save.

}