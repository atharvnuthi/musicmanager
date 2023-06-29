import java.util.Date;

public class Admin extends StructUser {
    public Admin(String name, String login, String password) {
        super(name, login, password);
    }

    public void addMusic(MusicCollection allMusics, StructMusic music) {
        boolean musicExists = false;
        for (StructMusic m : allMusics.getAllMusics()) {
            if (m.getTitle().equals(music.getTitle())) {
                musicExists = true;
                break;
            }
        }
        if (!musicExists) {
            allMusics.getAllMusics().add(music);
            allMusics.incrementMusics();
        }
    }

    public StructMusic searchMusic(MusicCollection allMusics, String title) {
        for (StructMusic m : allMusics.getAllMusics()) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return null;
    }

    public StructMusic searchMusic(MusicCollection allMusics, int id) {
        for (StructMusic m : allMusics.getAllMusics()) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public StructMusic removeMusic(MusicCollection allMusics, int id) {
        for (StructMusic m : allMusics.getAllMusics()) {
            if (m.getId() == id) {
                allMusics.getAllMusics().remove(m);
                allMusics.decrementMusics();
                return m;
            }
        }
        return null;
    }

    public StructMusic removeMusic(MusicCollection allMusics, String title) {
        for (StructMusic m : allMusics.getAllMusics()) {
            if (m.getTitle() == title) {
                allMusics.getAllMusics().remove(m);
                allMusics.decrementMusics();
                return m;
            }
        }
        return null;
    }

    public void updateMusic(MusicCollection allMusics, int id, String title, Duration duration, String authors,
            Date date, String genre) {
        StructMusic m = searchMusic(allMusics, id);
        if (m != null) {
            m.setTitle(title);
            m.setDuration(duration);
            m.setAuthors(authors);
            m.setDate(date);
            m.setGenre(genre);
        }
    }

    public void updateMusic(MusicCollection allMusics, String searchByTitle, String title, Duration duration,
            String authors, Date date, String genre) {
        StructMusic m = searchMusic(allMusics, searchByTitle);
        if (m != null) {
            m.setTitle(title);
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
        boolean userExists = false;
        for (User u : allUsers.getAllUsers()) {
            if (u.getLogin().equals(user.getLogin()) || u.getName().equals(user.getName())) {
                userExists = true;
                break;
            }
        }

        if (!userExists) {
            allUsers.getAllUsers().add(user);
            allUsers.incrementUsers();
        }
    }

    public void removeUser(UserCollection allUsers, User user) {
        for (User u : allUsers.getAllUsers()) {
            if (u.getLogin() == user.getLogin()) {
                allUsers.getAllUsers().remove(u);
                allUsers.decrementUsers();
            }
        }
    }

    public User searchUser(UserCollection allUsers, int id) {
        for (User u : allUsers.getAllUsers()) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public User searchUser(UserCollection allUsers, String login) {
        for (User u : allUsers.getAllUsers()) {
            if (u.getLogin().equals(login)) {
                return u;
            }
        }
        return null;
    }
}