/**
 * Package location for Model concepts.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a users register to store users.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */

public class UsersRegister {

    /**
     * List of users.
     */
    private List<User> usersList;

    /**
     * Default constructor of a UsersRegister class.
     */
    public UsersRegister() {

        this.usersList = new ArrayList<>();
    }

    /**
     * Constructor of a UsersRegister class.
     *
     * @param usersList list of users
     */
    public UsersRegister(List<User> usersList) {

        this.usersList = new ArrayList<>(usersList);
    }

    /**
     * Copy constructor of a UsersRegister class.
     *
     * @param usersRegister UserRegister to copy
     */
    public UsersRegister(UsersRegister usersRegister) {

        this.usersList = new ArrayList<>(usersRegister.getUsersList());
    }

    /**
     * Obtain the users list.
     *
     * @return the users list
     */
    public List<User> getUsersList() {
        return new ArrayList<>(this.usersList);
    }
    
    /**
     * Obtain the users list.
     * 
     * @param confirmed confirmed status of the users to fill the list
     * @return the users list
     */
    public List<User> getUsersList(boolean confirmed) {
        List <User> resultList = new ArrayList<>();
        for (User user: this.usersList) {
            if(user.getConfirmedStatus() == confirmed) {
                resultList.add(user);
            }
        }
        return resultList;
    }

    /**
     * Set the users list.
     *
     * @param usersList the users list to set
     */
 
    public void setUsersList(List<User> usersList) {
        this.usersList = new ArrayList<>(usersList);
    }
    
    /**
     * Registers a user
     * 
     * @param user user to be registered
     * @return true if is successfully registered, false otherwise
     */
    public boolean registerUser(User user) {
        return !this.usersList.contains(user) ? addUser(user) : false;
    }
    
    /**
     * Creates a new user.
     * 
     * @return new user
     */
    public User newUser() {
        return new User();
    }
    
     /**
     * Adds a user to the users list.
     * 
     * @param user user to be added
     * @return true if it is successfully added, false otherwise
     */
    private boolean addUser(User user) {
        return this.usersList.add(user);
    }
    
    
    /**
     * Return the textual representation of a usersRegister.
     *
     * @return the textual representation of a usersRegister
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("UsersRegister{");
        for (User user : this.usersList) {
            s.append(String.format("%s%n", user));
        }
        s.append("}");
        return s.toString();
    }
    
    
   
}
