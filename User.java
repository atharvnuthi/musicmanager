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

    public MusicCollection getMyMusics() {
        return myMusics;
    }

    // User is restricted to myMusics and cannot modify allMusics

    public void addMusic(MusicCollection allMusics, StructMusic music) {
        boolean musicExists = false;
        for (StructMusic m : allMusics.getAllMusics()) {
            if (m.getTitle().equals(music.getTitle())) {
                musicExists = true;
                break;
            }
        }
        if (musicExists == false) { // add from main collection
            allMusics.getAllMusics().add(music);
            allMusics.incrementMusics();
            myMusics.getAllMusics().add(music);
            myMusics.incrementMusics();
            System.out.println("Music added!");
        }
    }

    public StructMusic searchMusic(String title) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getTitle().equals(title)) {
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
                System.out.println("Music removed!");
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
                System.out.println("Music removed!");
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
            System.out.println("Music updated!");
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
            System.out.println("Music updated!");
        }
    }

    public void printMusics() {
        myMusics.printMusics();
    }
}