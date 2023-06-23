import java.util.Date;

public class Admin extends StructUser {
    public Admin(String nome, String login, String senha) {
        super(nome, login, senha);
    }

     //Novo metodo
    public void addMusic(MusicCollection collection, StructMusic music) {
	boolean musicExists = false;
        for (StructMusic m : collection.getAllMusics()) {
            if (m.getTitle().equals(music.getTitle())) {
                musicExists = true;
                break;
            }
        }
        if (!musicExists) {
            collection.getAllMusics().add(music);
            collection.addNumMusics();
        }
    }

     //Novo metodo
    public StructMusic searchMusic(MusicCollection collection, String title) {
        for (StructMusic m : collection.getAllMusics()) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return null;
    }
    
     //Novo metodo
    public StructMusic searchMusic(MusicCollection collection, int id) {
        for (StructMusic m : collection.getAllMusics()) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

     //Novo metodo
    public StructMusic removeMusic(MusicCollection collection, int id) {
        for (StructMusic m : collection.getAllMusics()) {
            if (m.getId() == id) {
                collection.getAllMusics().remove(m);
                collection.subNumMusics();
                return m;
            }
        }
        return null;
    }

     //Novo metodo
    public StructMusic removeMusic(MusicCollection collection, String title) {
        for (StructMusic m : collection.getAllMusics()) {
            if (m.getTitle() == title) {
                collection.getAllMusics().remove(m);
                collection.subNumMusics();
                return m;
            }
        }
        return null;
    }

     //Novo metodo
    public void updateMusic(MusicCollection collection, int id, String title, Duration duration, String authors, 
        Date date, String genre){
        StructMusic m = searchMusic(collection, id);
        if (m != null){
            m.setTitle(title);
            m.setDuration(duration);
            m.setAuthors(authors);
            m.setDate(date);
            m.setGenre(genre);
        } 
    }

     //Novo metodo
    public void updateMusic(MusicCollection collection, String oldTitle, String newTitle, Duration duration, String authors, 
        Date date, String genre){
        StructMusic m = searchMusic(collection, oldTitle);
        if (m != null){
            m.setTitle(newTitle);
            m.setDuration(duration);
            m.setAuthors(authors);
            m.setDate(date);
            m.setGenre(genre);
        } 
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