import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private List<String> emailIds;
    private List<String> phoneNumbers;
    private String location;
    private String username;
    private String password;

    //going to use similar class structure for User, with only addition being Username and Password, and a method to display user details? and perhaps the user class can directly be imported in Main class as User class is majorly for User management and viewing/editing profile.


    public User(String name, List<String> emailIds, List<String> phoneNumbers, String location, String username, String password){
        this.name = name;
        this.emailIds = new ArrayList<>(emailIds);
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
        this.location = location;
        this.username = username;
        this.password = password;
    }

    //now lets implement state management using getters and setters as all the data members are private

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //getter and setter for Username
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    //getter and setter for Password bruv seriously lol
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }



    //hmm, we can have multiple email ids for a single contact, so it's not a simple setEmailId that's why I think add? but now i got pnc, setEmailId works as well...   

    public List<String> getEmailIds(){
        return emailIds;
    }
    public void setEmailIds(String emailId){
        emailIds.add(emailId);
    }
    //what in the JAVA behaviour was this? I seriously thought I got an error ffs

    public List<String> getPhoneNumbers(){
        return phoneNumbers;
    }
    public void setPhoneNumbers(String phoneNumber){
        phoneNumbers.add(phoneNumber);
    }

    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }

    //ok so now we got out interface and class. next we should write another class to implement the interface/?? let's do it shall we.    





}
