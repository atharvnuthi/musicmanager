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

    public void addMusic(MusicCollection allMusics, StructMusic music) {
        if (this.isUser) {
            allMusics.addMusic(music);
            myMusics.addMusic(music);
        } else {
            this.myMusics = null;
        }
    }

    public void removeMusic(int id) {
        if (this.isUser) {
            myMusics.removeMusic(id);
        } else {
            this.myMusics = null;
        }
    }

    public void printMusics() {
        if (this.isUser) {
            myMusics.printMusics();
        } else {
            this.myMusics = null;
        }
    }

    public void searchMusic(int id) {
        if (this.isUser) {
            myMusics.searchMusic(id);
        } else {
            this.myMusics = null;
        }
    }

    public void searchMusic(String title) {
        if (this.isUser) {
            myMusics.searchMusic(title);
        } else {
            this.myMusics = null;
        }
    }
}
