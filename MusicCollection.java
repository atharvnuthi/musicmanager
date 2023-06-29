import java.util.ArrayList;
import java.util.Collection;

public class MusicCollection {
    private int numMusics;
    private Collection<StructMusic> allMusics;

    public MusicCollection() {
        this.numMusics = 0;
        this.allMusics = new ArrayList<StructMusic>();
    }

    public int getNumMusics() {
        return numMusics;
    }

    public Collection<StructMusic> getAllMusics() {
        return this.allMusics;
    }

    public void incrementMusics() {
        this.numMusics++;
    }

    public void decrementMusics() {
        this.numMusics--;
    }

    public void printMusics() {
        for (StructMusic m : allMusics) {
            System.out.println("--------------------");
            System.out.println("MUSIC_ID: " + m.getId());
            System.out.println("Name: " + m.getTitle());
            System.out.println("Duration: " + m.getDuration().getMin() + ":" + m.getDuration().getSec() + " min");
            System.out.println("Authors: " + m.getAuthors());
            System.out.println("Date: " + m.getDate().toString().substring(0, 10).replace("-", "/").replace(" ", "/"));
            System.out.println("Genre: " + m.getGenre());
        }
        System.out.println("--------------------");
    }
}
