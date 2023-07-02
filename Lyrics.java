import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Letra
public class Lyrics {
    private String fileLyrics;
    private String text = "";

    public Lyrics(String fileLyrics) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            this.fileLyrics = fileLyrics;
            fr = new FileReader(fileLyrics);
            br = new BufferedReader(fr);
            boolean eof = false;

            do {
                String s = br.readLine();
                if (s == null) {
                    eof = true;
                } else {
                    text = text + s + "\n";
                }
            } while (!eof);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getFileLyrics() {
        return text;
    }

    public void setFileLyrics(String fileLyrics) {
        this.fileLyrics = fileLyrics;
    }
}
