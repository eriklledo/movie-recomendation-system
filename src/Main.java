import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        MovieRecomendationManager mRM = new MovieRecomendationManager();
        Scanner sc = new Scanner(System.in);

        System.out.print("""
            
            --------------------------
            RECOMANADOR DE PEL·LÍCULES
            --------------------------
            """);

        boolean exit = false;

        while (!exit) {
            boolean login = false;

            do {
                System.out.print("""
                    
                    INICI DE SESSIÓ
                    
                    1. Nou usuari
                    2. Iniciar sessió
                    3. Entra com a convidat
                    0. Sortir del programa
                    
                    """);
                System.out.print("Triï una opció: ");

                switch (sc.nextInt()) {
                    case 1:
                        createUser(sc, mRM);
                        break;
                    case 2:
                        login = login(sc, mRM);
                        break;
                    case 3:
                        login = true;
                        break;
                    case 0:
                        System.out.println("\nFins aviat!");
                        System.out.println("Sortint del programa...");
                        exit = true;
                        break;
                    default:
                        System.out.println("\nOpció no vàlida. Torni a intentar-ho.");
                        break;
                }
            } while (!login && !exit);

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

                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("1");
                        break;
                    case 2:
                        System.out.println("2");
                        break;
                    case 3:
                        System.out.println("Ho sentim, aquesta funció encara no està disponible");
                        break;
                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        System.out.println("\nTancant sessió...");
                        login = false;
                        break;
                    case 0:
                        System.out.println("\nFins aviat!");
                        System.out.println("Sortint del programa...");
                        exit = true;
                        login = false;
                        break;
                    default:
                        System.out.println("Opció no vàlida. Torni a intentar-ho.");
                        break;
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

    public static void createUser(Scanner sc, MovieRecomendationManager mRM) {
        String username, email, password;

        do {
            System.out.print("\nNom d'usuari: ");
            username = sc.next();
            if (mRM.checkUser(username)) {
                System.out.println("Aquest nom d'usuari ja existeix. Torni-ho a intentar.");
                continue;
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Correu electrònic: ");
            email = sc.next();

            if (!MailChecking(email)) {
                System.out.println("Correu no vàlid. Torni a intentar-ho.\n");
                continue;
            }

            String finalEmail = email;
            if (mRM.getUsers().stream().anyMatch(user -> user.getMail().equals(finalEmail))) {
                System.out.println("Aquest correu electrònic ja està registrat. Torni a intentar-ho.");
            } else {
                break;
            }
        } while (true);

        do {
            System.out.print("Contrasenya: ");
            password = sc.next();

            if (!PasswordChecking(password)) {
                System.out.println("La contrasenya no compleix els requisits de seguretat.\n");
                continue;
            }

            System.out.print("Confirmi la contrasenya: ");
            if (password.equals(sc.next())) {
                break;
            }
            System.out.println("Les contrasenyes no coincideixen.\n");
        } while (true);

        mRM.addUser(new User(username, email, password));
        System.out.println("\nUsuari creat correctament!");
    }

    public static boolean login(Scanner sc, MovieRecomendationManager mRM) {
        while (true) {
            System.out.print("\nNom d'usuari o correu electrònic: ");
            String checkUser = sc.next();
            System.out.print("Contrasenya: ");
            String checkPasswd = sc.next();

            boolean userExists = mRM.checkUser(checkUser);
            boolean passwordCorrect = mRM.checkPassword(checkUser, checkPasswd);

            if (userExists && passwordCorrect) {
                System.out.println("\nS'ha iniciat sessió correctament");
                return true;
            }

            System.out.println("\nUsuari i/o contrasenya incorrectes");

            String answer;
            do {
                System.out.print("Vols registrar-te? (si/no): ");
                answer = sc.next().toLowerCase();
            } while (!answer.equals("si") && !answer.equals("no"));

            if (answer.equals("si")) return false;
        }
    }
}