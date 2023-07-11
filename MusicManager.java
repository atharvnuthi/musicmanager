import java.util.Date;
import java.util.Scanner;

public class MusicManager {
        private static MusicCollection allMusics = new MusicCollection();
        private static UserCollection allUsers = new UserCollection();

        private static boolean ISMAIN = true;

        private static Admin mainAdmin = new Admin("musicmanageradmin", "mma", "mma123");

        private static StructUser currentUser = null;
        private static User doUser = null;

        private static boolean isAdmin = false;
        private static boolean isUser = false;

        private static Scanner scanner = new Scanner(System.in);
        private static String currentUserName = null;

        public static void main(String[] args) {
                MusicManager m = new MusicManager();
                System.out.println("\nWelcome to Music Manager :)");
                while (ISMAIN == true) {
                        m.loginSystem();
                        if (isAdmin) {
                                System.out.println("\nAdmin Menu: " + currentUserName);
                                m.adminMenuManager();
                        }
                        if (isUser) {
                                System.out.println("\nUser Menu: " + currentUserName);
                                m.userMenuManager();
                        }
                }
                System.out.println("\nThank you for using our Music Manager :)");
        }

        private void initialPrint() {
                System.out.println("[1] = Login");
                System.out.println("[2] = Sign up");
                System.out.println("[*] = Exit");
                System.out.print("Choose what to do: ");
        }

        private void loginSystem() {
                boolean isExit = false;
                boolean isSignedUp = false;
                String login = null;
                String password = null;
                String checkPassword = null;
                String type = null;
                while (currentUser == null && isExit == false) {
                        initialPrint();
                        type = null;
                        switch (scanner.nextLine()) {
                                case "*":
                                        isExit = true;
                                        ISMAIN = false;
                                        break;

                                case "1":
                                        while (type == null) {
                                                System.out.print("\nAdmin(A) or User(U): ");
                                                type = scanner.nextLine();
                                                if (type.equals("A")) {
                                                        isAdmin = true;
                                                }
                                                if (type.equals("U")) {
                                                        isUser = true;
                                                }
                                                if (type.equals("*")) {
                                                        break;
                                                }
                                        }
                                        if (isAdmin) {
                                                System.out.print("Login: ");
                                                login = scanner.nextLine();
                                                if (login.equals("*")) {
                                                        break;
                                                }
                                                System.out.print("Password: ");
                                                password = scanner.nextLine();
                                                if (password.equals("*")) {
                                                        break;
                                                }
                                                if (mainAdmin.getLogin().equals(login) &&
                                                                mainAdmin.getPassword().equals(password)) {
                                                        currentUser = mainAdmin;
                                                        currentUserName = currentUser.getName();
                                                }
                                        }
                                        if (isUser) {
                                                System.out.print("Login: ");
                                                login = scanner.nextLine();
                                                if (login.equals("*")) {
                                                        break;
                                                }
                                                System.out.print("Password: ");
                                                password = scanner.nextLine();
                                                if (password.equals("*")) {
                                                        break;
                                                }
                                                User foundUser = allUsers.searchUser(login);
                                                if (foundUser != null && foundUser.getPassword().equals(password)) {
                                                        currentUser = foundUser;
                                                        doUser = foundUser;
                                                        currentUserName = currentUser.getName();
                                                        System.out.println("User logged in!\n");
                                                } else {
                                                        System.out.println(
                                                                        "Invalid login or password. Please try again.\n");
                                                }
                                        }
                                        break;

                                case "2":
                                        while (isSignedUp == false) {
                                                System.out.print("Name: ");
                                                String name = scanner.nextLine();
                                                if (name.equals("*")) {
                                                        break;
                                                }
                                                System.out.print("Login: ");
                                                login = scanner.nextLine();
                                                if (login.equals("*")) {
                                                        break;
                                                }
                                                do {
                                                        System.out.print("Password: ");
                                                        password = scanner.nextLine();
                                                        if (password.equals("*")) {
                                                                break;
                                                        }
                                                        System.out.print("Type the same password again: ");
                                                        checkPassword = scanner.nextLine();
                                                        if (checkPassword.equals("*")) {
                                                                break;
                                                        }
                                                        if (password.equals(checkPassword) == false) {
                                                                System.out.println("Different passwords, try again!");
                                                        }
                                                } while (password.equals(checkPassword) == false);
                                                isSignedUp = allUsers.register(name, login, password);
                                                if (isSignedUp) {
                                                        System.out.println("User signed up!\n");
                                                        isSignedUp = false;
                                                        break;
                                                } else {
                                                        System.out.println("Login already exists, try again!\n");
                                                }
                                        }
                                        break;
                        }

                }
        }

        private void adminMenuPrint() {
                System.out.println("[1] = Music add");
                System.out.println("[2] = Music search");
                System.out.println("[3] = Music update");
                System.out.println("[4] = Music remove");
                System.out.println("[5] = Music view");
                System.out.println("[6] = User add");
                System.out.println("[7] = User search");
                System.out.println("[8] = User remove");
                System.out.println("[*] = Exit");
        }

        private void userMenuPrint() {
                System.out.println("[1] = Music add");
                System.out.println("[2] = Music update");
                System.out.println("[3] = Music remove");
                System.out.println("[4] = Music view");
                System.out.println("[5] = Music search");
                System.out.println("[*] = Exit");
        }

        private void adminMenuManager() {
                adminMenuPrint();
                boolean isIn = true;
                while (isIn == true && isAdmin == true) {
                        System.out.print("\nChoose what to do: ");
                        switch (scanner.nextLine()) {
                                case "*":
                                        isIn = false;
                                        isAdmin = false;
                                        currentUser = null;
                                        break;

                                case "1":
                                        System.out.print("Musical Instrument (M) or Song (S): ");
                                        String type = scanner.nextLine();
                                        if (type.equals("M")) {
                                                mainAdmin.addMusic(allMusics,
                                                                new MusicalInstrument("MusicalInstrument",
                                                                                new Duration(1, 0), "authorMI",
                                                                                new Date(), "genreIns",
                                                                                "sheetMusicName"));
                                        }
                                        if (type.equals("S")) {
                                                mainAdmin.addMusic(allMusics,
                                                                new Song("Song", new Duration(2, 0),
                                                                                "authorS", new Date(), "genreSong",
                                                                                new Lyrics("lyrics.txt")));
                                        }
                                        break;

                                case "2":
                                        System.out.print("Enter Music Title: ");
                                        String title = scanner.nextLine();
                                        StructMusic tempMusic = mainAdmin.searchMusic(allMusics, title);
                                        if (tempMusic != null) {
                                                tempMusic.printMusic();
                                        } else {
                                                System.out.println("No music found!");
                                        }
                                        break;

                                case "3":
                                        mainAdmin.updateMusic(allMusics, "Song", "New Song",
                                                        new Duration(3, 0),
                                                        "authorsNS", new Date(), "genreNewSong");
                                        break;

                                case "4":
                                        mainAdmin.removeMusic(allMusics, "New Song");
                                        break;

                                case "5":
                                        mainAdmin.printMusics(allMusics);
                                        break;

                                case "6":
                                        mainAdmin.addUser(allUsers, new User("Atharv", "athu", "athu123"));
                                        break;

                                case "7":
                                        System.out.print("Enter User Login: ");
                                        String login = scanner.nextLine();
                                        User tempUser = mainAdmin.searchUser(allUsers, login);
                                        if (tempUser != null) {
                                                System.out.println(tempUser.toString());
                                        }
                                        break;

                                case "8":
                                        mainAdmin.removeUser(allUsers, "athu");
                                        break;
                        }
                }
        }

        private void userMenuManager() {
                userMenuPrint();
                boolean isIn = true;
                while (isIn == true && isUser == true) {
                        System.out.print("\nChoose what to do: ");
                        switch (scanner.nextLine()) {
                                case "*":
                                        isIn = false;
                                        isUser = false;
                                        currentUser = null;
                                        doUser = null;
                                        break;

                                case "1":
                                        System.out.print("Musical Instrument (M) or Song (S): ");
                                        String type = scanner.nextLine();
                                        if (type.equals("M")) {
                                                doUser.addMusic(allMusics, new MusicalInstrument("MyMusicalInstrument",
                                                                new Duration(1, 0), "myAuthor", new Date(), "myGenre",
                                                                "sheetMusicName"));

                                        }
                                        if (type.equals("S")) {
                                                doUser.addMusic(allMusics, new Song("MySong", new Duration(0, 0),
                                                                "myAuthor", new Date(), "myGenre",
                                                                new Lyrics("lyrics.txt")));
                                        }
                                        break;

                                case "2":
                                        doUser.updateMusic("MySong", "MyNewSong", new Duration(1, 0),
                                                        "myNewAuthors", new Date(), "myNewGenre");
                                        break;

                                case "3":
                                        doUser.removeMusic("MyMusicalInstrument");
                                        break;

                                case "4":
                                        doUser.printMusics();
                                        break;

                                case "5":
                                        System.out.print("Enter Music Title: ");
                                        String title = scanner.nextLine();
                                        StructMusic tempMusic = doUser.searchMusic(title);
                                        if (tempMusic != null)
                                                tempMusic.printMusic();
                                        ;
                                        break;
                        }
                }
        }
}