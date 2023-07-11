import java.util.Date;

// Canção 
public class Song extends StructMusic {
    private Lyrics lyrics;

    public Song(String title, Duration duration, String authors, Date date, String genre, Lyrics lyrics) {
        super(title, duration, authors, date, genre);
        this.lyrics = lyrics;
        System.out.print((lyrics.getFileLyrics())); // print to show that the lyrics are being read
    }

    public Lyrics getLyrics() {
        return lyrics;
    }
}