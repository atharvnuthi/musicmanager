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
                boolean isSigned = false;
                String login = null;
                String password = null;
                String checkPassword = null;
                String type = null;
                while (currentUser == null && isExit == false) {
                        initialPrint();
                        type = null;
                        boolean isCancel = false;
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
                                                }
                                                currentUserName = currentUser.getName();
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
                                                if (allUsers.searchUser(login).getPassword().equals(password)) {
                                                        currentUser = allUsers.searchUser(login);
                                                        doUser = allUsers.searchUser(login);

                                                }
                                                currentUserName = currentUser.getName();
                                        }
                                        break;

                                case "2":
                                        while (isSigned == false && isCancel == false) {
                                                System.out.print("Name: ");
                                                String name = scanner.nextLine();
                                                if (name.equals("*")) {
                                                        isCancel = true;
                                                        break;
                                                }
                                                System.out.print("Login: ");
                                                login = scanner.nextLine();
                                                if (login.equals("*")) {
                                                        isCancel = true;
                                                        break;
                                                }
                                                do {
                                                        System.out.print("Password: ");
                                                        password = scanner.nextLine();
                                                        if (password.equals("*")) {
                                                                isCancel = true;
                                                                break;
                                                        }
                                                        System.out.print("Type the same password again: ");
                                                        checkPassword = scanner.nextLine();
                                                        if (checkPassword.equals("*")) {
                                                                isCancel = true;
                                                                break;
                                                        }
                                                        if (password.equals(checkPassword) == false) {
                                                                System.out.println("Different passwords, try again!");
                                                        }
                                                } while (password.equals(checkPassword) == false);
                                                isSigned = allUsers.register(name, login, password);
                                        }
                                        System.out.println("User signed up!");
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
                                                mainAdmin.addMusic(allMusics, new MusicalInstrument("title",
                                                                new Duration(0, 0), "authors", new Date(), "genre",
                                                                "sheetMusicName"));
                                        }
                                        if (type.equals("S")) {
                                                mainAdmin.addMusic(allMusics, new Song("title", new Duration(0, 0),
                                                                "authors", new Date(), "genre",
                                                                new Lyrics("lyrics.txt")));
                                        }
                                        break;

                                case "2":
                                        System.out.print("Enter Music Title: ");
                                        String title = scanner.nextLine();
                                        StructMusic tempMusic = mainAdmin.searchMusic(allMusics, title);
                                        if (tempMusic != null) {
                                                System.out.println(tempMusic.toString());
                                        }
                                        break;

                                case "3":
                                        mainAdmin.updateMusic(allMusics, "title", "new title", new Duration(0, 1),
                                                        "new authors", new Date(), "new genre");
                                        break;

                                case "4":
                                        mainAdmin.removeMusic(allMusics, "title");
                                        break;

                                case "5":
                                        mainAdmin.printMusics(allMusics);
                                        break;

                                case "6":
                                        mainAdmin.addUser(allUsers, new User("name", "login", "password"));
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
                                        mainAdmin.removeUser(allUsers, "login");
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
                                                doUser.addMusic(allMusics, new MusicalInstrument("title",
                                                                new Duration(0, 0), "authors", new Date(), "genre",
                                                                "sheetMusicName"));
                                        }
                                        if (type.equals("S")) {
                                                doUser.addMusic(allMusics, new Song("title", new Duration(0, 0),
                                                                "authors", new Date(), "genre",
                                                                new Lyrics("lyrics.txt")));
                                        }
                                        break;

                                case "2":
                                        doUser.updateMusic("title", "new title", new Duration(0, 1),
                                                        "new authors", new Date(), "new genre");
                                        break;

                                case "3":
                                        doUser.removeMusic("title");
                                        break;

                                case "4":
                                        doUser.printMusics();
                                        break;

                                case "5":
                                        System.out.print("Enter Music Title: ");
                                        String title = scanner.nextLine();
                                        StructMusic tempMusic = doUser.searchMusic(title);
                                        if (tempMusic != null) {
                                                System.out.println(tempMusic.toString());
                                        }
                                        break;
                        }
                }
        }
}