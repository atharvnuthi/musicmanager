import java.util.Date;
import java.util.Scanner;

public class MusicManager {
        public static MusicCollection allMusics = new MusicCollection();
        public static UserCollection allUsers = new UserCollection();
        private static Admin mainAdmin = new Admin("musicmanageradmin", "mma", "mma123");
        private static StructUser currentUser = null;
        private static Scanner scanner = new Scanner(System.in);
        private static boolean isAdmin = false;
        private static boolean isUser = false;
        private static String login = null;
        private static String name = null;
        private static String password = null;
        private static String password2 = null;
        private static String type = null;

        public static void main(String[] args) {
                MusicManager m = new MusicManager();
                m.login_sys();
                if (isAdmin){
                        System.out.println("Admin Menu");
                        m.adminMenu();
                }
                if (isUser){
                        System.out.println("User Menu");
                        m.userMenu();
                }
        }

        private void initialize(){
                System.out.println("[1] = Login");
                System.out.println("[2] = Sign up");
                System.out.println("[*] = Exit");
        }

        private void login_sys(){
                boolean exit = false;
                boolean signed = false;
                while (currentUser == null && exit == false){
                        initialize();
                        type = null;
                        boolean cancel = false;
                        switch(scanner.nextLine()){
                                case "*":
                                exit = true;
                                break;

                                case "1":
                                while (type == null){
                                        System.out.print("Admin(A) or User(U): "); 
                                        type = scanner.nextLine();
                                        if (type.equals("A")){
                                                isAdmin = true;
                                        }
                                        if (type.equals("U")){
                                                isUser = true;
                                        }
                                        if (type.equals("*")){
                                                break;
                                        }
                                }
                                if (isAdmin){
                                        System.out.print("Login: ");
                                        login = scanner.nextLine();
                                        if (login.equals("*")){
                                                break;
                                        }
                                        System.out.print("Password: ");
                                        password = scanner.nextLine();
                                        if (password.equals("*")){
                                                break;
                                        }
                                        if (mainAdmin.getLogin().equals(login) && 
                                                mainAdmin.getPassword().equals(password)){
                                                        currentUser = mainAdmin;
                                        }
                                        name = currentUser.getName();
                                }
                                if (isUser){
                                        System.out.print("Login: ");
                                        login = scanner.nextLine();
                                        if (login.equals("*")){
                                                break;
                                        }
                                        System.out.print("Password: ");
                                        password = scanner.nextLine();
                                        if (password.equals("*")){
                                                break;
                                        }
                                        if (allUsers.searchUser(login).getPassword().equals(password)){
                                                currentUser = allUsers.searchUser(login);
                                        }
                                        name = currentUser.getName();
                                }
                                break;

                                case "2":
                                while(signed == false && cancel == false){
                                        System.out.print("Name: ");
                                        String name = scanner.nextLine();
                                        if(name.equals("*")){
                                                cancel = true;
                                                break;
                                        }
                                        System.out.print("Login: ");
                                        login = scanner.nextLine();
                                        if (login.equals("*")){
                                                cancel = true;
                                                break;
                                        }
                                        do{
                                                System.out.print("Password: ");
                                                password = scanner.nextLine();
                                                if (password.equals("*")){
                                                        cancel = true;
                                                        break;
                                                }
                                                System.out.print("Type the same password again: ");
                                                password2 = scanner.nextLine();
                                                if (password2.equals("*")){
                                                        cancel = true;
                                                        break;
                                                }
                                                if (password.equals(password2) == false){
                                                        System.out.println("Different passwords, try again");
                                                }
                                        } while(password.equals(password2) == false);
                                        signed = allUsers.register(name, login, password);
                                }
                                System.out.println("User signed up");
                                break;
                        }


                }
        }

        private void adminMenu(){
                System.out.println("[1] = Music add");
                System.out.println("[2] = Music search");
                System.out.println("[3] = Music update");
                System.out.println("[4] = Music remove");
                System.out.println("[5] = User add");
                System.out.println("[6] = User search");
                System.out.println("[7] = User remove");
                System.out.println("[*] = Exit");
        }

        private void userMenu(){
                System.out.println("[1] = New Collection");
                System.out.println("[2] = Music add");
                System.out.println("[3] = Music update");
                System.out.println("[4] = Music remove");
                System.out.println("[5] = Music view");
                System.out.println("[7] = User remove");
                System.out.println("[*] = Exit");
        }
}

// Admin, User - StructUser
// MusicalInstrument, Song -> StructMusic

// Users -> UserCollection
// StructMusics (MusicalInstrument, Song) -> MusicCollection

// MusicalInstrument (String musicSheet, Duration duration)
// Song (Lyrics lyrics, Duration duration)
