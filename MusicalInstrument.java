import java.util.Date;

// Música Instrumental
public class MusicalInstrument extends StructMusic {
    public String musicSheet;

    public MusicalInstrument(String title, Duration duration, String authors, Date date, String genre,
            String sheetMusicName) {
        super(title, duration, authors, date, genre);
        this.musicSheet = sheetMusicName; // name do arquivo com a imagem da partitura
    }

    public String getMusicSheet() {
        return musicSheet;
    }

    public void setMusicSheet(String musicSheet) {
        this.musicSheet = musicSheet;
    }
}