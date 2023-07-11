import java.util.Date;

public abstract class StructMusic {
    private static int uniqueMusicIds = 0;
    private int id;
    private String title;
    private Duration duration;
    private String authors;
    private Date date;
    private String genre;

    public StructMusic(String title, Duration duration, String authors, Date date, String genre) {
        this.title = title;
        this.duration = duration;
        this.authors = authors;
        this.date = date;
        this.genre = genre;
        uniqueMusicIds++;
        this.id = uniqueMusicIds;
    }

    public String toString() {
        return "Title: " + title + "\nDuration: " + duration + "\nAuthors: " + authors + "\nDate: " + date + "\nGenre: "
                + genre;
    }

    public void printMusic() {
        System.out.println("--------------------");
        System.out.println("MUSIC_ID: " + this.id);
        System.out.println("Name: " + this.title);
        System.out.println("Duration: " + this.duration.getMin() + ":" + this.duration.getSec() + " min");
        System.out.println("Authors: " + this.authors);
        System.out.println("Date: " + this.date.toString().substring(0, 10).replace("-", "/").replace(" ", "/"));
        System.out.println("Genre: " + this.genre);
        System.out.println("--------------------");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}