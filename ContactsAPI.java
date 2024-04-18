import java.util.List;
import java.util.ArrayList;

public class ContactsAPI implements Contacts {
    //inherit contacts interface first ? and then use our Contact class to perform operations perhaps. let's try this.
    //Here's my another problem with JAVA, I am already writing my 3rd file, but I still can't compile to test it if its working as expected. Because even though this is the third file, I actually haven't written anything worth compiling lol.
    //Now let me add this as well, I know why its important, and even though I "technically" don't need to write 3 files in any other programming language, I should as whatever I did untill this point was to make my code TypeSafe. I know that, thanks.
    private List<Contact> contactsList;

    public List<Contact> listAllContacts(){
        return contactsList;
    }

    public ContactsAPI(){
        this.contactsList = new ArrayList<>();
    }

    @Override
    public void addContact(Contact contact){
        contactsList.add(contact);
    }

    //the basic idea is to override only findcontact, and then let ui decide what type of key it is, is it phone number, email id or name.
    //ok let's try something, so search by in my UI will be of type only string, so I can call this findContact with a string like before but instead of name, just make it key/identifier and then, call different methods depending on the key, ok let's try
    @Override
    public Contact findContact(String key){
        //first find it by key if contact remains null, we move on
        Contact contact = findContactByName(key);
        if(contact != null){
            return contact;
        }

        //now we search by number, lol
        contact = findContactByPhoneNumber(key);
        if(contact != null){
            return contact;
        }

        //ok now finally, if contact was still null, we search by email id
        contact = findContactByEmailId(key);
        if(contact != null){
            return contact;
        }

        //finally if it was not found anywhere, we return failed the return type is contact. for obvious reasons, so we simply return the contact for now, and if it is null in the UI, we say no results found??? or should I make a new Contact object and return it? Let's leave it like this for now, this note will come in handy later.
        return contact;

    }

    public Contact findContactByName(String name){
        for(Contact contact : contactsList){
            if(contact.getName().equalsIgnoreCase(name)){
                return contact;
            }
        }
        //yeah we can do this, then we don't need to make a new null contact at end of findContact()
        return null;
    }

    public Contact findContactByPhoneNumber(String phoneNumber){
        for(Contact contact : contactsList){
            if(contact.getPhoneNumbers().contains(phoneNumber)){
                return contact;
            }
        }
        
        return null;

    }

    public Contact findContactByEmailId(String emailId){
        for(Contact contact : contactsList){
            if(contact.getEmailIds().contains(emailId)){
                return contact;
            }
        }
        
        return null;
    }

    @Override
    public Contact viewContact(String name){
        return findContactByName(name);
    }

    // so for edit contact, I don't have any idea right now how this will supposedly work. I will need to send current name, along with the whole contact object perhaps, to make changes, because even though a very small one, there's still a possiblity that someone might want to change a contact name?
    //or wait, should I find the contact using findContact() first, and then make changes to the contact?
    //wait again, what if, I just pass two contact objects, one is original contact used to search based on everything, and then next is updated data, this will work better perhaps
    @Override
    public void editContact(Contact originalContact, Contact updatedContact){
        for(Contact existingContact : contactsList){
            if(existingContact==originalContact){
                //update contact using updatedContact

                existingContact.setName(updatedContact.getName());

                existingContact.getEmailIds().clear();
                existingContact.getEmailIds().addAll(updatedContact.getEmailIds());

                existingContact.getPhoneNumbers().clear();
                existingContact.getPhoneNumbers().addAll(updatedContact.getPhoneNumbers());

                existingContact.setLocation(updatedContact.getLocation());

                return;
                
            }
        }

        return;

    }

    @Override
    public void deleteContact(String name){
        Contact contactToDelete = findContactByName(name);
        if(contactToDelete != null){
            contactsList.remove(contactToDelete);
        }
    }


}
