import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        UserManager rM = new UserManager();
        Scanner sc = new Scanner(System.in);
    }

    public static void loginMenu(Scanner sc, UserManager rM) {
        boolean inMenu = true;

        while (inMenu) {
            System.out.println("""
                    
                    RECOMANADOR DE PEL·LÍCULES
                    
                    Trieu una opció
                    1. Crear usuari
                    2. Iniciar sessió
                    3. Sortir de programa
                    
                    """);
            System.out.print("Triï una opció: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> createUser(sc, rM);
                case 2 -> signin(sc, rM);
                case 3 -> inMenu = false;
                default -> System.out.println("Opció no vàlida. Torni a intentar-ho.");
            }
        }
        sc.close();
    }

    public static void moviesMenu() {

    }

    public static boolean MailChecking(String mail) {
        Pattern verifyEmail = Pattern.compile("([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)");
        Matcher search = verifyEmail.matcher(mail);
        return search.matches();
    }

    public static boolean PasswordChecking(String password) {

        Pattern securePassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher search = securePassword.matcher(password);
        return search.matches();

    }

    public static void defaultUsers() {
        User erik = new User(1, "Èrik", LocalDate.of(2004, 10, 15), "Spanish", "sonwerik", "sonwerik@mail.com", "miau");
    }

    public static void createUser(Scanner sc, UserManager rM) {
        String username;
        String email = "";
        String password = "";

        System.out.print("Introdueixi un nom d'usuari: ");
        username = sc.next();

        boolean inMail = true;
        while (inMail) {
            System.out.print("Introdueixi el seu correu: ");
            email = sc.next();

            if (!MailChecking(email)) {
                System.out.println("Correu no vàlid. Torni a intentar-ho.\n");
                continue;
            }
            break;
        }

        boolean inCreatePasswd = true;
        while (inCreatePasswd) {
            System.out.print("Introdueixi una contrasenya: ");
            password = sc.next();

            if (!PasswordChecking(password)) {
                System.out.println("La contrasenya no compleix els requisits de seguretat.\n");
                continue;
            }
            break;
        }

        boolean inCheckPasswd = true;
        while (inCheckPasswd) {
            System.out.print("Repeteixi la contrasenya: ");
            String confirmPassword = sc.next();

            if (!password.equals(confirmPassword)) {
                System.out.println("Les contrasenyes no coincideixen.\n");
                continue;
            }
            break;
        }

        User user = new User(username, email, password);

        rM.addUser(user);
        System.out.println("\nUsuari creat correctament!");
    }

    public static void signin(Scanner sc, UserManager user) {
        boolean signIn = true;
        while (signIn) {
            System.out.print("Introdueixi el nom d'usuari o correu electronic: ");
            String checkUser = sc.next();
            System.out.print("Introdueixi un contrasenya: ");
            String checkPasswd = sc.next();

            if (!user.checkUser(checkUser) || !user.checkPassword(checkPasswd)) {
                signIn = false;
                System.out.println("Usuari i/o contrsenya incorrectes\n");
            }
        }
        System.out.println("S'ha iniciat sessió correctament");
    }
}
