import java.util.ArrayList;
import java.util.Collection;

public class UserCollection {
    private int numUsers;
    private Collection<User> allUsers;

    public UserCollection() {
        this.numUsers = 0;
        this.allUsers = new ArrayList<User>();
    }

    public boolean register(String name, String login, String password) {
        boolean userExists = false;
        for (User u : allUsers) {
            if (u.getLogin().equals(login)) {
                userExists = true;
                System.out.println("User already exist");
                return false;
            }
        }
        if (!userExists) {
            User sendUser = new User(name, login, password);
            allUsers.add(sendUser);
            numUsers++;
            return true;
        }
        return false;
    }

    public User login(String login, String password) {
        for (User u : allUsers) {
            if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public User searchUser(String login){
        for (User u : allUsers){
            if (u.getLogin().equals(login)){
                return u;
            }
        }

        return null;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void incrementUsers() {
        this.numUsers++;
    }

    public void decrementUsers() {
        this.numUsers--;
    }

    public Collection<User> getAllUsers() {
        return this.allUsers;
    }
}
