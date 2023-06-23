import java.util.Date;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class MusicManager {
        public static MusicCollection allMusics = new MusicCollection();
        public static UserCollection allUsers = new UserCollection();

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                User user;
                String login;
                String password;
                String password2;
                boolean exit = false;
                while(exit == false){
                        switch(scanner.nextLine()){
                        
                        case "login": 
                        try{
                                System.out.print("Login: ");
                                login = scanner.nextLine();
                                System.out.print("Password: ");
                                password = scanner.nextLine();
                                user = allUsers.searchUser(login);
                                if (user.getPassword().equals(password) == false){
                                        System.out.println("Wrong password");
                                }
                        }
                        catch(NullPointerException n){
                                System.out.println("User does not exist");
                        }     
                        break;

/* ------------------------------------------------------------------------------------------------------- */
                        
                        case "sign up":
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Login: ");
                        login = scanner.nextLine();
                        do{
                                System.out.print("Password: ");
                                password = scanner.nextLine();
                                System.out.print("Type the same password again: ");
                                password2 = scanner.nextLine();
                                if (password.equals(password2) == false){
                                        System.out.println("Different passwords, try again");
                                }
                        } while(password.equals(password2) == false);
                        allUsers.addUser(new User(name, login, password));
                        System.out.println("User signed up");
                        break;

/* ------------------------------------------------------------------------------------------------------- */

                        case "help": System.out.println("sign up ; login ; help ; exit");
                        break;
                        
/* ------------------------------------------------------------------------------------------------------- */

                        case "exit": exit = true;
                        break;


                        }
                }
        scanner.close();

        }
}