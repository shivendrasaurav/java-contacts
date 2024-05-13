import java.util.List;
import java.util.ArrayList;

public class UsersAPI implements Users {
    //Yeah because Users doesn't exist right now, but its an simple interface, so it won't need much editing, this is the main file where we have to make changes
    //On second thought, I might rather implement it in API style directly for when I will be connecting it to a database or a file system, I would rather give an option to store more than 1 user data.
    private List<User> usersList;

    public List<User> listAllUsers(){
        return usersList;
    }

    public UsersAPI(){
        this.usersList = new ArrayList<>();
    }

    @Override
    public User loginUser(String username, String password){
        // yeah simple auth, if username and password match, then login. And right now, I'm thinking of only a single user, to make it easier to work on the UI

        //yeah so I think, I will perhaps use find user function already written instead of again worrying about that.
        //check if username exists:
        //welp, it needs to be implemented, even though its gonna be a simple edit

        User user = findUserByUsername(username);

        //and now just compare passwords eh ??
        if(user.getPassword().equals(password)){
            return user;
        }

        //if passwords dont match, return null
        return null;

    }

    @Override
    public void addUser(User user){
        usersList.add(user);
    }

    //the basic idea is to override only finduser, and then let ui decide what type of key it is, is it phone number, email id or name.
    //ok let's try something, so search by in my UI will be of type only string, so I can call this findUser with a string like before but instead of name, just make it key/identifier and then, call different methods depending on the key, ok let's try
    @Override
    public User findUser(String key){
        //first find it by key if user remains null, we move on
        User user = findUserByName(key);
        if(user != null){
            return user;
        }

        //now we search by number, lol
        user = findUserByPhoneNumber(key);
        if(user != null){
            return user;
        }

        //ok now finally, if user was still null, we search by email id
        user = findUserByEmailId(key);
        if(user != null){
            return user;
        }

        //finally if it was not found anywhere, we return failed the return type is user. for obvious reasons, so we simply return the user for now, and if it is null in the UI, we say no results found??? or should I make a new User object and return it? Let's leave it like this for now, this note will come in handy later.
        //why not directly return null? data type should not matter because its null, and nothing else, should it?
        return null;

    }

    public User findUserByUsername(String username){
        for(User user : usersList){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        //yeah we can do this, then we don't need to make a new null user at end of findUser()

        //because check here, i'm returning null here as well, with return type User, which was contacts initially, so it should work for login as well??
        return null;
    }

    public User findUserByName(String name){
        for(User user : usersList){
            if(user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
        //yeah we can do this, then we don't need to make a new null user at end of findUser()
        return null;
    }

    public User findUserByPhoneNumber(String phoneNumber){
        for(User user : usersList){
            if(user.getPhoneNumbers().contains(phoneNumber)){
                return user;
            }
        }
        
        return null;

    }

    public User findUserByEmailId(String emailId){
        for(User user : usersList){
            if(user.getEmailIds().contains(emailId)){
                return user;
            }
        }
        
        return null;
    }

    @Override
    public User viewUser(String name){
        return findUserByName(name);
    }

    // so for edit user, I don't have any idea right now how this will supposedly work. I will need to send current name, along with the whole user object perhaps, to make changes, because even though a very small one, there's still a possiblity that someone might want to change a user name?
    //or wait, should I find the user using findUser() first, and then make changes to the user?
    //wait again, what if, I just pass two user objects, one is original user used to search based on everything, and then next is updated data, this will work better perhaps
    @Override
    public void editUser(User originalUser, User updatedUser){
        for(User existingUser : usersList){
            if(existingUser==originalUser){
                //update user using updatedUser

                existingUser.setName(updatedUser.getName());

                existingUser.getEmailIds().clear();
                existingUser.getEmailIds().addAll(updatedUser.getEmailIds());

                existingUser.getPhoneNumbers().clear();
                existingUser.getPhoneNumbers().addAll(updatedUser.getPhoneNumbers());

                existingUser.setLocation(updatedUser.getLocation());

                return;
                
            }
        }

        return;

    }

    @Override
    public void deleteUser(String name){
        User userToDelete = findUserByName(name);
        if(userToDelete != null){
            usersList.remove(userToDelete);
        }
    }


}
