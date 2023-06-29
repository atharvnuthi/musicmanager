import java.util.Date;
import java.util.Scanner;

public class MusicManager {
        public static MusicCollection allMusics = new MusicCollection();
        public static UserCollection allUsers = new UserCollection();
        private static Admin mainAdmin = new Admin("musicmanageradmin", "mma", "mma123");
        private static User currentUser = null;
        private static Scanner scanner = new Scanner(System.in);
        private static boolean isAdmin = false;
        private static boolean isUser = false;

        public static void main(String[] args) {
                // implement logic here to show to professor
        }
}

// Admin, User - StructUser
// MusicalInstrument, Song -> StructMusic

// Users -> UserCollection
// StructMusics (MusicalInstrument, Song) -> MusicCollection

// MusicalInstrument (String musicSheet, Duration duration)
// Song (Lyrics lyrics, Duration duration)
