import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        MovieRecomendationManager manager = new MovieRecomendationManager();
        Scanner sc = new Scanner(System.in);

        System.out.print("""
                
                --------------------------
                RECOMANADOR DE PEL·LÍCULES
                --------------------------
                
                """);

        while (true) {
            boolean loggedIn = showLoginMenu(sc, manager);
            if (!loggedIn) {
                System.out.println("\nSortint del programa...");
                System.out.println("Fins aviat!");
                sc.close();
                return;
            }

            boolean exit = showMovieMenu(sc);
            if (exit) {
                System.out.println("\nSortint del programa...");
                System.out.println("Fins aviat!");
                sc.close();
                return;
            }
        }
    }

    private boolean showLoginMenu(Scanner sc, MovieRecomendationManager manager) {
        while (true) {
            try {
                System.out.print("""
                        INICI DE SESSIÓ
                        
                        1. Nou usuari
                        2. Iniciar sessió
                        3. Entra com a convidat
                        0. Sortir del programa
                        
                        """);
                System.out.print("Triï una opció: ");

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        createUser(sc, manager);
                        break;
                    case 2:
                        if (login(sc, manager)) return true;
                        break;
                    case 3:
                        return true;
                    case 0:
                        return false;
                    default:
                        System.out.println("\nOpció no vàlida. Torni a intentar-ho.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nNomés s'accepten nombres enters.\n");
                sc.nextLine();
            }
        }
    }

    private boolean showMovieMenu(Scanner sc) {
        while (true) {
            try {
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

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        // TODO
                    case 2:
                        // TODO
                    case 3:
                        System.out.println("Ho sentim, aquesta funció encara no està disponible");
                    case 4:
                        // TODO
                    case 5:
                        System.out.println("\nTancant sessió...\n");
                        return false;
                    case 0:
                        return true;
                    default:
                        System.out.println("Opció no vàlida. Torni a intentar-ho.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nNomés s'accepten nombres enters.");
                sc.nextLine();
            }
        }
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

    public static void createUser(Scanner sc, MovieRecomendationManager manager) {
        String username, email, password;

        while (true) {
            try {
                System.out.print("\nNom d'usuari: ");
                username = sc.nextLine();

                if (username.contains(" ")) {
                    throw new IllegalArgumentException("El nom d'usuari no pot contenir espais.");
                }
                if (manager.checkUser(username)) {
                    System.out.println("Aquest nom d'usuari ja existeix. Torni-ho a intentar.");
                    continue;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Correu electrònic: ");
                email = sc.nextLine();

                if (email.contains(" ")) {
                    throw new IllegalArgumentException("El correu electrònic no pot contenir espais.");
                }
                if (!MailChecking(email)) {
                    System.out.println("Correu no vàlid\n");
                    continue;
                }

                String finalEmail = email;
                if (manager.getUsers().stream().anyMatch(user -> user.getMail().equals(finalEmail))) {
                    System.out.println("Aquest correu electrònic ja està registrat\n");
                    continue;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.print("Contrasenya: ");
                password = sc.nextLine();

                if (password.contains(" ")) {
                    throw new IllegalArgumentException("La contrasenya no pot contenir espais.");
                }
                if (!PasswordChecking(password)) {
                    System.out.println("La contrasenya no compleix els requisits de seguretat\n");
                    continue;
                }

                System.out.print("Confirmi la contrasenya: ");
                if (!password.equals(sc.next())) {
                    System.out.println("Les contrasenyes no coincideixen\n");
                    continue;
                }
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        manager.addUser(new User(username, email, password));
        System.out.println("\nUsuari creat correctament!\n");
    }

    public static boolean login(Scanner sc, MovieRecomendationManager manager) {
        while (true) {
            try {
                System.out.print("\nNom d'usuari: ");
                String checkUser = sc.nextLine();

                if (checkUser.contains(" ")) {
                    throw new IllegalArgumentException("El nom d'usuari no pot contenir espais.");
                }

                System.out.print("Contrasenya: ");
                String checkPasswd = sc.nextLine();

                if (checkPasswd.contains(" ")) {
                    throw new IllegalArgumentException("La contrasenya no pot contenir espais.");
                }

                boolean userExists = manager.checkUser(checkUser);
                boolean passwordCorrect = manager.checkPassword(checkUser, checkPasswd);

                if (userExists && passwordCorrect) {
                    System.out.println("\nS'ha iniciat sessió correctament");
                    return true;
                }

                System.out.println("\nUsuari i/o contrasenya incorrectes");

                String answer;
                do {
                    System.out.print("Vols tornar enrere per registrar-te: ");
                    answer = sc.next().toLowerCase();
                } while (!answer.equals("si") && !answer.equals("no"));

                if (answer.equals("si")) return false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}