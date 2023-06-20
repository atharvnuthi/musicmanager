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

    public void addMusic(StructMusic music) {
        boolean musicExists = false;
        for (StructMusic m : allMusics) {
            if (m.getTitle().equals(music.getTitle())) {
                musicExists = true;
                break;
            }
        }

        if (!musicExists) {
            allMusics.add(music);
            numMusics++;
        }
    }

    public StructMusic searchMusic(String title) {
        for (StructMusic m : allMusics) {
            if (m.getTitle() == title) {
                return m;
            }
        }
        return null;
    }

    public StructMusic searchMusic(int id) {
        for (StructMusic m : allMusics) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public StructMusic removeMusic(int id) {
        for (StructMusic m : allMusics) {
            if (m.getId() == id) {
                allMusics.remove(m);
                this.numMusics--;
                return m;
            }
        }
        return null;
    }

    public StructMusic removeMusic(String title) {
        for (StructMusic m : allMusics) {
            if (m.getTitle() == title) {
                allMusics.remove(m);
                this.numMusics--;
                return m;
            }
        }
        return null;
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
