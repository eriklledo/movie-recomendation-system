import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        UserManager uM = new UserManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                
                RECOMANADOR DE PEL·LÍCULES
                
                """);

        boolean inLoginMenu = true;
        while (inLoginMenu) {
            System.out.println("""
                    
                    INICI DE SESSIÓ
                    
                    1. Nou usuari
                    2. Iniciar sessió
                    3. Sortir de programa
                    
                    """);
            System.out.print("Triï una opció: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> createUser(sc, uM);
                case 2 -> login(sc, uM);
                case 3 -> inLoginMenu = false;
                default -> System.out.println("Opció no vàlida. Torni a intentar-ho.");
            }
        }

        if (login(sc,uM)) {
            boolean inMovieMenu = true;
            while (inMovieMenu){
                System.out.println("""
                
                PEL·LÍCULES DISPONIBLES
                
                1. Llistat de pel·lícules disponibles
                2. Cercador de pel·lícules
                3. Recomanador de pel·lícules (no disponible)
                4. El meu Perfil
                5. Tancar sessió
                0. Sortir del programa
                
                """);
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1 -> System.out.println("1");
                    case 2 -> System.out.println("2");
                    case 3 -> System.out.println("3");

                    case 4 -> {
                        System.out.println("Ho sentim, aquesta funció, encara no está disponible");
                        continue;
                    }
                    case 5 -> System.out.println("5");
                    case 6 -> {
                        break;
                    }
                    case 0 -> System.exit(0);
                    default -> System.out.println("Opció no vàlida. Torni a intentar-ho.");
                }
            }
        }
        sc.close();
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

    public static void createUser(Scanner sc, UserManager uM) {
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

        uM.addUser(user);
        System.out.println("\nUsuari creat correctament!");
    }

    public static boolean login(Scanner sc, UserManager user) {
        boolean login = true;
        while (login) {
            System.out.print("Introdueixi el nom d'usuari o correu electronic: ");
            String checkUser = sc.next();
            System.out.print("Introdueixi un contrasenya: ");
            String checkPasswd = sc.next();

            if (!user.checkUser(checkUser) || !user.checkPassword(checkPasswd)) {
                login = false;
                System.out.println("Usuari i/o contrsenya incorrectes\n");
            }
        }
        System.out.println("S'ha iniciat sessió correctament");
        return login;
    }
}