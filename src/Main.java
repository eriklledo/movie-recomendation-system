import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        MovieRecomendationManager mRM = new MovieRecomendationManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                
                RECOMANADOR DE PEL·LÍCULES
                """);

        boolean login = false;
        while (!login) {
            login = menu1(sc,mRM);
            while (login) {
                System.out.println("""
                    
                    PEL·LÍCULES DISPONIBLES
                    
                    1. Llistat de pel·lícules disponibles
                    2. Cercador de pel·lícules
                    3. Recomanador de pel·lícules (no disponible)
                    4. El meu Perfil
                    5. Tancar sessió
                    0. Sortir del programa
                    
                    """);
                System.out.print("Triï una opció: ");
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("1");
                        mRM.listMovies();
                        break;

                    case 2:
                        System.out.println("2");
                        //TODO
                        break;

                    case 3:
                        System.out.println("Ho sentim, aquesta funció, encara no está disponible");
                        break;

                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        System.out.println("5");
                        login = false;
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Opció no vàlida. Torni a intentar-ho.");
                }
            }
        }
        sc.close();
    }

    public static boolean menu1(Scanner sc, MovieRecomendationManager mRM){
        boolean login = false;
        System.out.println("""
                    
                    INICI DE SESSIÓ
                    
                    1. Nou usuari
                    2. Iniciar sessió
                    3. Entra com a convidat
                    0. Sortir de programa
                    
                    """);
        System.out.print("Triï una opció: ");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                mRM.addUser(createUser(sc, mRM));
                break;
            case 2:
                login(sc, mRM);
                System.out.println(login);
                break;
            case 3:
                login = true;
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Opció no vàlida. Torni a intentar-ho.");
        }
        return login;
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

    public static void defaultUsers(MovieRecomendationManager mRM) {
        User erik = new User(1, "Èrik", LocalDate.of(2004, 10, 15), "Spanish", "sonwerik", "sonwerik@mail.com", "miau");
        mRM.addUser(erik);
    }

    public static User createUser(Scanner sc, MovieRecomendationManager mRM) {
        String username = "";
        String email = "";
        String password = "";

        while (true) {
            System.out.print("Introdueixi un nom d'usuari: ");
            username = sc.next();
            if (mRM.checkUser(username)) {
                System.out.println("Aquest nom d'usuari ja existeix. Torni-ho a intentar.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Introdueixi el seu correu: ");
            email = sc.next();

            if (!MailChecking(email)) {
                System.out.println("Correu no vàlid. Torni a intentar-ho.\n");
                continue;
            }

            String finalEmail = email;
            if (mRM.getUsers().stream().anyMatch(user -> user.getMail().equals(finalEmail))) {
                System.out.println("Aquest correu electrònic ja està registrat. Torni-ho a intentar.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Introdueixi una contrasenya: ");
            password = sc.next();

            if (!PasswordChecking(password)) {
                System.out.println("La contrasenya no compleix els requisits de seguretat.\n");
                continue;
            }

            System.out.print("Repeteixi la contrasenya: ");
            String confirmPassword = sc.next();

            if (!password.equals(confirmPassword)) {
                System.out.println("Les contrasenyes no coincideixen.\n");
                continue;
            }
            break;
        }

        System.out.println("\nUsuari creat correctament!");
        return new User(username, email, password);

    }

    public static boolean login(Scanner sc,MovieRecomendationManager mRM) {
        while (true) {
            System.out.print("Introdueixi el nom d'usuari o correu electronic: ");
            String checkUser = sc.next();
            System.out.print("Introdueixi un contrasenya: ");
            String checkPasswd = sc.next();

            if (!mRM.checkUser(checkUser) || !mRM.checkPassword(checkUser, checkPasswd)) {
                System.out.println("\nUsuari i/o contrsenya incorrectes");

                while (true) {
                    System.out.println("Vols registrar-te? (si/no)");
                    String answer = sc.next().toLowerCase();

                    if (answer.equals("si")) return false;
                    if (answer.equals("no")) break;
                    System.out.println("Si us plau, respongui amb “si” o “no”.");
                }

            } else {
                System.out.println("\nS'ha iniciat sessió correctament");
                return true;
            }
        }
    }
}