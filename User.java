import java.util.Date;

public class User extends StructUser {
    private MusicCollection myMusics;

    public User(String name, String login, String password) {
        super(name, login, password);
        this.myMusics = new MusicCollection();
    }

    public String toString() {
        return "Name: " + this.getName() + "\nLogin: " + this.getLogin() + "\nPassword: " + this.getPassword();
    }

    public void addMusic(MusicCollection allMusics, StructMusic music) {
        boolean musicExists = false;
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getTitle().equals(music.getTitle())) {
                musicExists = true;
                break;
            }
        }
        if (!musicExists) {
            myMusics.getAllMusics().add(music);
            allMusics.getAllMusics().add(music);
            myMusics.incrementMusics();
            allMusics.incrementMusics();
        }
    }

    public StructMusic searchMusic(String title) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return null;
    }

    public StructMusic searchMusic(int id) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getId() == id) {
                m.toString();
            }
        }
        return null;
    }

    public StructMusic removeMusic(int id) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getId() == id) {
                myMusics.getAllMusics().remove(m);
                myMusics.decrementMusics();
                return m;
            }
        }
        return null;
    }

    public StructMusic removeMusic(String title) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getTitle() == title) {
                myMusics.getAllMusics().remove(m);
                myMusics.decrementMusics();
                return m;
            }
        }
        return null;
    }

    public void updateMusic(int id, String title, Duration duration, String authors,
            Date date, String genre) {
        StructMusic m = searchMusic(id);
        if (m != null) {
            m.setTitle(title);
            m.setDuration(duration);
            m.setAuthors(authors);
            m.setDate(date);
            m.setGenre(genre);
        }
    }

    public void updateMusic(String oldTitle, String newTitle, Duration duration, String authors,
            Date date, String genre) {
        StructMusic m = searchMusic(oldTitle);
        if (m != null) {
            m.setTitle(newTitle);
            m.setDuration(duration);
            m.setAuthors(authors);
            m.setDate(date);
            m.setGenre(genre);
        }
    }

    public void printMusics() {
        if (myMusics != null) {
            myMusics.printMusics();
        }
    }
}
