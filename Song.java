import java.util.Date;

public class Song extends StructMusic {
    private Lyrics lyrics;

    public Song(String title, Duration duration, String authors, Date date, String genre, Lyrics lyrics) {
        super(title, duration, authors, date, genre);
        this.lyrics = lyrics;
    }

    public Lyrics getLyrics() {
        return lyrics;
    }
}