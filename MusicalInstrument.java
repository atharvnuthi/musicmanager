import java.util.Date;

public class MusicalInstrument extends StructMusic {
    public String musicSheet;

    public MusicalInstrument(String title, Duration duration, String authors, Date date, String genre,
            String sheetMusicName) {
        super(title, duration, authors, date, genre);
        this.musicSheet = sheetMusicName;
    }

    public String getMusicSheet() {
        return musicSheet;
    }

    public void setMusicSheet(String musicSheet) {
        this.musicSheet = musicSheet;
    }
}