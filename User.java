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
    public void addMusic(StructMusic music) {
	boolean musicExists = false;
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getTitle().equals(music.getTitle())) {
                musicExists = true;
                break;
            }
        }
        if (!musicExists) {
            myMusics.getAllMusics().add(music);
            myMusics.addNumMusics();
        }
    }

    //Novo metodo
    public StructMusic searchMusic(String title) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return null;
    }
    
    //Novo metodo
    public StructMusic searchMusic(int id) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    //Novo metodo
    public StructMusic removeMusic(int id) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getId() == id) {
                myMusics.getAllMusics().remove(m);
                myMusics.subNumMusics();
                return m;
            }
        }
        return null;
    }

    //Novo metodo
    public StructMusic removeMusic(String title) {
        for (StructMusic m : myMusics.getAllMusics()) {
            if (m.getTitle() == title) {
                myMusics.getAllMusics().remove(m);
                myMusics.subNumMusics();
                return m;
            }
        }
        return null;
    }

    //Novo metodo
    public void updateMusic(int id, String title, Duration duration, String authors, 
        Date date, String genre){
        StructMusic m = searchMusic(id);
        if (m != null){
            m.setTitle(title);
            m.setDuration(duration);
            m.setAuthors(authors);
            m.setDate(date);
            m.setGenre(genre);
        } 
    }

    //Novo metodo
    public void updateMusic(String oldTitle, String newTitle, Duration duration, String authors, 
        Date date, String genre){
        StructMusic m = searchMusic(oldTitle);
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
