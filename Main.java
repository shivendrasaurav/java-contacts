import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{

    public static void main(String args[]){

        ContactsAPI contactList = new ContactsAPI();
        int choice;
        String inputLine;
        boolean flag=true;

        try (Scanner sc = new Scanner(System.in)) {
            //display a basic menu?
            while (flag) {

                System.out.print("\033[H\033[2J");  
                System.out.flush();

                System.out.println("\nChoose an option: ");
                System.out.println("\n1. Show all contacts ");
                System.out.println("\n2. Search for a contact ");
                System.out.println("\n3. Add a contact ");
                System.out.println("\n4. Edit a contact ");
                System.out.println("\n5. Delete a contact ");
                System.out.println("\n6. Exit ");

                choice = sc.nextInt();
                sc.nextLine();


                //ok so here's the issue. I have contactsAPI which implements contacts, so I can only use methods from contacts interface
                //which reminds me of listAllContatcs, which I should implement directly there lol. ok let's try that.
                switch (choice) {
                    case 1:

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        System.out.println("All Listed Contacts");
                        System.out.println("NAME: Phone Numbers");
                        List<Contact> allContacts = contactList.listAllContacts();

                        if(allContacts.isEmpty()){
                            System.out.println("No contacts found");
                        }else{
                            for(Contact contact : allContacts){
                                System.out.println(contact.getName() + " : " + contact.getPhoneNumbers());
                            }    
                        }                        
                        break;
                    case 2:

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        System.out.println("Search by name, email id or phone number");
                        inputLine = sc.nextLine();
                        contactList.findContact(inputLine);
                    case 3:

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        System.out.println("Name for contact - ");
                        String name = sc.nextLine();
                        System.out.println("Primary phone number for contact (Only add one for now) - ");
                        String primaryNumber = sc.nextLine();
                        List<String> phoneNumbers = new ArrayList<>();
                        phoneNumbers.add(primaryNumber);
                        System.out.println("Primary email id for contact (Only add one for now) - ");
                        String primaryEmail = sc.nextLine();
                        List<String> emailIds = new ArrayList<>();
                        emailIds.add(primaryEmail);
                        System.out.println("Location for contact - ");
                        String location = sc.nextLine();

                        System.out.println("Adding this info: " + phoneNumbers + emailIds);

                        Contact newContact = new Contact(
                            name, 
                            emailIds, 
                            phoneNumbers, 
                            location
                        );
                        
                        contactList.addContact(newContact);

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                        System.out.println("Added contact : " + newContact);

                    case 6:
                        flag = false;

                        System.out.print("\033[H\033[2J");  
                        System.out.flush();

                    //need to implement atleast add contact to test this, other stuff I will directly work with UI
                    default:
                        break;
                }

            }
        }


    }
    
}