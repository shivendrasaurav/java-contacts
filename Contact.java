import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String name;
    private List<String> emailIds;
    private List<String> phoneNumbers;
    private String location;

    //we will go with a simple parameterized constructor as we don't need to worry about initializing and empty contact on its own. Only after all validations are done on UI component, we will call the contact constructor to create the object.

    public Contact(String name, List<String> emailIds, List<String> phoneNumbers, String location){
        this.name = name;
        this.emailIds = new ArrayList<>(emailIds);
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
        this.location = location;
    }

    //now lets implement state management using getters and setters as all the data members are private

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public List<String> getEmailIds(){
        return emailIds;
    }
    //hmm, we can have multiple email ids for a single contact, so it's not a simple setEmailId that's why I think add? but now i got pnc, setEmailId works as well...
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
