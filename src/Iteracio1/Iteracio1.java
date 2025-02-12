//package Iteracio1;
//
//import java.util.*;
//
//public class Iteracio1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        boolean loggedIn = false;
//        String createUsername = "";
//        String createPass = "";
//        String checkPass = "";
//        String email = "";
//        String username = "";
//        String favMovie = "";
//        String back = "";
//
//        ArrayList<String[]> movies = new ArrayList<>();
//        movies.add(new String[]{"Inception", "Action, Adventure, Science Fiction", "Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ken Watanabe", "2010"});
//        movies.add(new String[]{"The Godfather", "Crime, Drama", "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan, Robert Duvall", "1972"});
//        movies.add(new String[]{"Pulp Fiction", "Crime, Thriller", "Quentin Tarantino", "John Travolta, Samuel L. Jackson, Uma Thurman, Bruce Willis", "1994"});
//        movies.add(new String[]{"Joker", "Crime, Drama, Thriller", "Todd Phillips", "Joaquin Phoenix, Robert De Niro, Zazie Beetz", "2019"});
//        movies.add(new String[]{"Django Unchained", "Western", "Quentin Tarantino", "Jamie Foxx, Christoph Waltz, Leonardo DiCaprio, Kerry Washington, Samuel L. Jackson, Walton Goggins", "2012"});
//        movies.add(new String[]{"Taxi Driver", "Drama, Crime", "Martin Scorsese", "Robert De Niro, Jodie Foster, Cybill Shepherd, Harvey Keitel", "1976"});
//        movies.add(new String[]{"The Silence of the Lambs", "Horror, Crime, Thriller, Drama", "Jonathan Demme", "Jodie Foster, Anthony Hopkins, Scott Glenn, Ted Levine", "1991"});
//        movies.add(new String[]{"GoodFellas", "Drama, Crime", "Martin Scorsese", "Robert De Niro, Ray Liotta, Joe Pesci, Lorraine Bracco", "1990"});
//        movies.add(new String[]{"Interstellar", "Science Fiction, Drama, Adventure", "Christopher Nolan", "Matthew McConaughey, Anne Hathaway, Michael Caine", "2014"});
//        movies.add(new String[]{"The Devil Wears Prada", "Comedy, Drama", "David Frankel", "Meryl Streep, Anne Hathaway, Emily Blunt, Stanley Tucci", "2006"});
//        movies.add(new String[]{"Killers of the Flower Moon", "History, Crime, Drama", "Martin Scorsese", "Leonardo DiCaprio, Robert De Niro, Lily Gladstone", "2023"});
//        movies.add(new String[]{"Psycho", "Mystery, Thriller, Horror", "Alfreed Hitchcock", "Anthony Perkins, Janet Leigh, Vera Miles, John Gavin", "1960"});
//        movies.add(new String[]{"Eyes Wide Shut", "Thriller, Drama, Mystery", "Stanley Kubrick", "Tom Cruise, Nicole Kidman, Sydney Pollack", "1999"});
//
//        while (!loggedIn) {
//
//            boolean opcioValida = false;
//            int opcioMenu = 0;
//
//            while (!opcioValida)
//                try {
//                    System.out.println("\n\nRECOMANADOR DE PEL·LÍCULES\n");
//                    System.out.println("1. Crear un compte");
//                    System.out.println("2. Iniciar sessió");
//                    System.out.println("3. Sortir del programa");
//                    System.out.print("\nTriï una opció: ");
//
//                    opcioMenu = sc.nextInt();
//
//                    if (opcioMenu < 1 || opcioMenu > 3) {
//                        System.out.println("Ha d'escollir un número del 1 al 3");
//                    } else {
//                        opcioValida = true;
//                    }
//                } catch (InputMismatchException e) {
//                    System.out.println("Ha d'escollir un número del 1 al 3");
//                    sc.nextLine();
//                }
//
//            switch (opcioMenu) {
//
//                case 1:
//                    boolean samePass = false;
//                    while (!samePass) {
//                        System.out.print("Introdueixi el seu correu: ");
//                        email = sc.next();
//                        System.out.print("Introdueixi un nom d'usuari: ");
//                        createUsername = sc.next();
//                        System.out.print("Introdueixi una contrasenya: ");
//                        createPass = sc.next();
//                        System.out.print("Repeteixi la contrasenya: ");
//                        checkPass = sc.next();
//                        if (!Objects.equals(createPass, checkPass)) {
//                            System.out.println("\nLes contrasenyes no coincideixen");
//                        } else if (checkPass.equals(createPass)) {
//                            System.out.println("\nCompte creat correctament! Si us plau, inicieu sessió.");
//                            samePass = true;
//                        }
//                    }
//                    break;
//
//                case 2:
//                    while (!loggedIn) {
//
//                        System.out.print("Introdueixi el nom d'usuari o correu electrònic: ");
//                        username = sc.next();
//                        System.out.print("Introdueixi la contrasenya: ");
//                        String pass = sc.next();
//
//                        if (username.equals(email) || username.equals(createUsername)) {
//
//                            if (pass.equals(createPass)) {
//                                System.out.println("\nHa iniciat sessió correctament!");
//                                loggedIn = true;
//                            } else {
//                                System.out.println("Contasenya incorrecta");
//                            }
//                        } else {
//                            System.out.println("Usuari i/o contrasenya incorrectes.");
//                            System.out.print("\nVols registrarte? ");
//                            String goToSingUp = sc.next().toLowerCase();
//                            if (goToSingUp.equals("si")) break;
//                            else if (goToSingUp.equals("no")) continue;
//                            else System.out.println("Si us plau, respongui amb “si” o “no”.");
//                        }
//                    }
//
//                    while (loggedIn) {
//
//                        int opcioPelis = 0;
//                        boolean opcioValida2 = false;
//
//                        while (!opcioValida2) {
//
//                            try {
//                                System.out.println("\nPEL·LÍCULES DISPONIBLES\n");
//                                System.out.println("1. Llistat de pel·lícules disponibles");
//                                System.out.println("2. Cercador de pel·lícules");
//                                System.out.println("3. Mostrar Perfil");
//                                System.out.println("4. Tancar sessió");
//                                System.out.println("5. Sortir del programa");
//                                System.out.print("\nTriï una opció: ");
//                                opcioPelis = sc.nextInt();
//                                sc.nextLine();
//
//                                if (opcioPelis < 1 || opcioPelis > 5) {
//                                    System.out.println("Ha d'escollir un número del 1 al 5");
//                                } else {
//                                    opcioValida2 = true;
//                                }
//                            } catch (InputMismatchException e) {
//                                System.out.println("Ha d'escollir un número del 1 al 3");
//                                sc.nextLine();
//                            }
//                        }
//                        switch (opcioPelis) {
//                            case 1:
//                                boolean found = false;
//                                while (!found) {
//                                    movies.sort(Comparator.comparing(a -> a[0]));
//                                    System.out.println("\nMostrant les pel·lícules disponibles:\n");
//                                    for (String[] movie : movies) {
//                                        System.out.println("- " + movie[0]);
//                                    }
//
//                                    System.out.print("\nVols tornar enrere? ");
//                                    back = sc.next();
//                                    if (back.equalsIgnoreCase("si")) {
//                                        break;
//                                    } else if (back.equalsIgnoreCase("no")) found = false;
//                                    else System.out.println("Si us plau, respongui amb “si” o “no”.");
//                                }
//                                break;
//
//                            case 2:
//                                found = false;
//                                while (!found) {
//                                    System.out.print("\nCerca una pel·lícula: ");
//                                    String film = sc.nextLine().toLowerCase();
//                                    System.out.println();
//
//                                    for (String[] movie : movies) {
//                                        if (movie[0].toLowerCase().contains(film) || movie[1].toLowerCase().contains(film) || movie[2].toLowerCase().contains(film) || movie[3].toLowerCase().contains(film) || movie[4].toLowerCase().contains(film)) {
//                                            System.out.println("Títol: " + movie[0]);
//                                            System.out.println("Gènere: " + movie[1]);
//                                            System.out.println("Director: " + movie[2]);
//                                            System.out.println("Actors Principals: " + movie[3]);
//                                            System.out.println("Any: " + movie[4]);
//                                            System.out.println();
//                                            found = true;
//                                        }
//                                    }
//                                    if (!found) System.out.println("Ho sentim, no s'ha trobat aquest titol.\n");
//
//                                    while (true) {
//                                        System.out.print("Vols tornar enrere? ");
//                                        back = sc.nextLine();
//                                        if (back.equalsIgnoreCase("si")) {
//                                            break;
//                                        } else if (back.equalsIgnoreCase("no")) {
//                                            found = false;
//                                        } else System.out.println("Si us plau, respongui amb “si” o “no”.");
//                                    }
//                                }
//                                break;
//
//                            case 3:
//                                System.out.println("\nBenvingut al teu perfil\n");
//                                System.out.println("Usuari: " + username);
//                                System.out.println("Email: " + email);
//                                System.out.print("Introdueixi la seva pel·lícula preferida: ");
//                                favMovie = sc.nextLine();
//
//                                for (String favMovies : movies) {
//                                    if (movie.toLowerCase().contains(film) || movie[1].toLowerCase().contains(film) || movie[2].toLowerCase().contains(film) || movie[3].toLowerCase().contains(film) || movie[4].toLowerCase().contains(film)) {
//                                        System.out.println("Títol: " + movie[0]);
//                                        System.out.println("Gènere: " + movie[1]);   // esto lo he puesto para hacer mi parte
//                                        System.out.println("Director: " + movie[2]);
//                                        System.out.println("Actors Principals: " + movie[3]);
//                                        System.out.println("Any: " + movie[4]);
//                                        System.out.println();
//                                        found = true;
//                                    }
//                                }
//                                if (!found) System.out.println("Ho sentim, no s'ha trobat aquest titol.\n");
//
//                                while (favMovie.isEmpty()) ;
//                                System.out.println("\nBenvingut al teu perfil\n");
//                                System.out.println("Usuari: " + username);
//                                System.out.println("Email: " + email);
//                                System.out.println("Pel·licula preferida: " + favMovie);
//
//                                System.out.print("\nVols tornar enrere? ");
//                                back = sc.next();
//                                if (back.equals("si")) break;
//                                else if (back.equals("no")) continue;
//                                else System.out.println("Si us plau, respongui amb “si” o “no”.");
//
//                                break;
//                                case 4:
//                                loggedIn = false;
//                                break;
//
//                            case 5:
//                                System.out.println("Sortint del programa. Fins aviat!");
//                                System.exit(0);
//
//                            default:
//                                System.out.println("Opció no vàlida.");
//                                break;
//                        }
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("Sortint del programa. Fins aviat!");
//                    System.exit(0);
//
//                default:
//                    System.out.println("Opció no vàlida.");
//                    break;
//            }
//        }
//    }
//}
//
