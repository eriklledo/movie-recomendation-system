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

            boolean exit = showMovieMenu(sc, manager);
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
                        enterToContinue(sc);
                        break;
                    case 2:
                        if (login(sc, manager)) return true;
                        break;
                    case 3:
                        System.out.println();
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

    private boolean showMovieMenu(Scanner sc, MovieRecomendationManager manager) {
        while (true) {
            try {
                System.out.println("""                        
                        RECOMANADOR DE PEL·LÍCULES
                        
                        1. Llistat de pel·lícules disponibles
                        2. Cercador de pel·lícules
                        3. Recomanador de pel·lícules (no disponible)
                        4. El meu Perfil
                        5. Buscar perfil
                        6. Acceptar peticions d'amistat
                        7. Tancar sessió
                        0. Sortir del programa
                        """);
                System.out.print("Triï una opció: ");

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        manager.listMovies();
                        enterToContinue(sc);
                        break;
                    case 2:
                        movieSearcher(sc, manager);
                        enterToContinue(sc);
                        break;
                    case 3:
                        System.out.println("\nHo sentim, aquesta funció encara no està disponible\n");
                        enterToContinue(sc);
                        break;
                    case 4:
                        // TODO
                        System.out.println();
                        enterToContinue(sc);
                        break;
                    case 5:
                        profileSearcher(sc, manager);
                        enterToContinue(sc);
                        break;
                    case 6:
                        manageFriendRequests(sc, manager);
                        enterToContinue(sc);
                        break;
                    case 7:
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
        String username, mail, password;

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
                mail = sc.nextLine();

                if (mail.contains(" ")) {
                    throw new IllegalArgumentException("El correu electrònic no pot contenir espais.");
                }
                if (!MailChecking(mail)) {
                    System.out.println("Correu no vàlid\n");
                    continue;
                }

                String finalEmail = mail;
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
                if (!password.equals(sc.nextLine())) {
                    System.out.println("Les contrasenyes no coincideixen\n");
                    continue;
                }
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        manager.addUser(new User(username, mail, password));
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
                    manager.setCurrentUser(manager.findUserByUsername(checkUser));
                    System.out.println("\nS'ha iniciat sessió correctament\n");
                    return true;
                }

                System.out.println("\nUsuari i/o contrasenya incorrectes");

                String answer;
                do {
                    System.out.print("Vols tornar enrere i registrar-te? ");
                    answer = sc.nextLine().toLowerCase();
                    if (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("n")) {
                        System.out.println("\nRespon ❝si❞ o ❝no❞");
                    }
                } while (!answer.equalsIgnoreCase("si") && !answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("n"));

                if (answer.equalsIgnoreCase("si") || answer.equalsIgnoreCase("s")) {
                    return false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\nRespon ❝si❞ o ❝no❞");
            }
        }
    }

    public static void movieSearcher(Scanner sc, MovieRecomendationManager manager) {
        System.out.print("\nCerca una pel·lícula: ");
        manager.filterMovies(sc.nextLine()).forEach(System.out::println);
    }

    public static void manageFriendRequests(Scanner sc, MovieRecomendationManager manager) {
        System.out.println("\nTens " + manager.getCurrentUser().getPendingFR().size() + " solicituts d'amistat:");
        System.out.println(manager.getCurrentUser().getPendingFR());

        System.out.println("\n1. Acceptar sol·licitud d'amistad");
        System.out.println("2. Tornar enrere");

        System.out.println("Triï una opció: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.print("Indica la petició a acceptar: ");
                int friendToAdd = sc.nextInt();
                sc.nextLine();
                manager.acceptFriendRequest(manager.getCurrentUser().getPendingFR().get(friendToAdd - 1));
                break;

            case 2:
                break;
        }
    }

    public static void profileSearcher(Scanner sc, MovieRecomendationManager manager) {
        System.out.print("\nCerca un nom d'usuari: ");
        try {
            User foundUser = manager.findUserByUsername(sc.nextLine());

            if (foundUser == null) {
                throw new NullPointerException();
            }

            if (foundUser.getUsername().equals(manager.getCurrentUser().getUsername())) {
                System.out.println("\nNo es pot enviar sol·licitud d'amistat a si mateix");
            } else {
                if (manager.areTheyFriends(manager.getCurrentUser(), foundUser)) {
                    System.out.print("Vols veure el perfil de " + foundUser.getUsername() + "? ");
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("si")) {
                        displayProfile(foundUser);
                    }
                } else {
                    System.out.print("Vols afegir a " + foundUser.getUsername() + " com a amic? ");
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("si")) {
                        manager.addFriend(manager.getCurrentUser(), foundUser);
                        System.out.println("Sol·licitud d'amistat enviada");
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("\nIniciï sessió per demanar sol·licituds d'amistat");
        }
        System.out.println();
    }

    public static void displayProfile(User u) {
        System.out.println(u);
    }

    public static void enterToContinue(Scanner sc) {
        System.out.print("Prem enterToContinue per continuar.\n");
        sc.nextLine();
    }
}