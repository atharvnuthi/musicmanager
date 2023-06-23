import java.util.Date;

public class User extends StructUser {
    private MusicCollection myMusics;
    private boolean isUser;

    public User(String name, String login, String password) {
        super(name, login, password);
        this.myMusics = new MusicCollection();
        this.isUser = true;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
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

    public void printMusics() {
        if (this.isUser) {
            myMusics.printMusics();
        } else {
            this.myMusics = null;
        }
    }
}
