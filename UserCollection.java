import java.util.ArrayList;
import java.util.Collection;

public class UserCollection {
    private int numUsers;
    private Collection<User> allUsers;

    public UserCollection() {
        this.numUsers = 0;
        this.allUsers = new ArrayList<User>();
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void addUser(User user) {
        boolean userExists = false;
        for (User u : allUsers) {
            if (u.getLogin().equals(user.getLogin())) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            allUsers.add(user);
            numUsers++;
        }
        allUsers.add(user);
        numUsers++;
    }

    public User searchUser(String login) {
        for (User u : allUsers) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }

    public User searchUser(int id) {
        for (User u : allUsers) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public User removeUser(int id) {
        for (User u : allUsers) {
            if (u.getId() == id) {
                allUsers.remove(u);
                this.numUsers--;
                return u;
            }
        }
        return null;
    }

    public User removeUser(String login) {
        for (User u : allUsers) {
            if (u.getLogin().equals(login)) {
                allUsers.remove(u);
                this.numUsers--;
                return u;
            }
        }
        return null;
    }
}
