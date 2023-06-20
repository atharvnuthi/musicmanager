import java.util.Date;

public class Admin extends StructUser {
    public Admin(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    public void addMusic(MusicCollection allMusics, StructMusic music) {
        allMusics.addMusic(music);
    }

    public StructMusic searchMusic(MusicCollection allMusics, String title) {
        return allMusics.searchMusic(title);
    }
    
    public StructMusic searchMusic(MusicCollection allMusics, int id) {
        return allMusics.searchMusic(id);
    }

    public void updateMusic(MusicCollection allMusics, int id, String title, Duration duration, String authors, 
        Date date, String genre){
        allMusics.updateMusic(allMusics, id, title, duration, authors, date, genre);
    }

    public void updateMusic(MusicCollection allMusics, String oldTitle, String newTitle, Duration duration, String authors, 
        Date date, String genre){
        allMusics.updateMusic(allMusics, oldTitle, newTitle, duration, authors, date, genre);
    }

    public void removeMusic(MusicCollection allMusics, int id) {
        allMusics.removeMusic(id);
    }

    public void removeMusic(MusicCollection allMusics, String title) {
        allMusics.removeMusic(title);
    }

    public void printMusics(MusicCollection allMusics) {
        allMusics.printMusics();
    }

    public void addUser(UserCollection allUsers, User user) {
        allUsers.addUser(user);
    }

    public void removeUser(UserCollection allUsers, User user) {
        allUsers.removeUser(user.getLogin());
        user.setIsUser(false);
    }

    public User searchUser(UserCollection allUsers, int id) {
        return allUsers.searchUser(id);
    }

    public User searchUser(UserCollection allUsers, String login) {
        return allUsers.searchUser(login);
    }
}