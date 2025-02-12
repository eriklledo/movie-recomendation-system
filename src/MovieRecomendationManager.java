import java.time.LocalDate;
import java.util.*;

public class MovieRecomendationManager {
    private Set<Movie> movies;
    private Set<User> users;

    public MovieRecomendationManager() {
        this.movies = new HashSet<>();
        this.users = new HashSet<>();
        addUser(new User("admin", "bustiad@gmail.com", "@dm1n"));
        addUser(new User(1, "Èrik", LocalDate.of(2004, 10, 15), "Spanish", "erik", "sonwerik@mail.com", "miau"));
        addUser(new User(2, "Jordi", LocalDate.of(2000, 1, 1), "Spanish", "jordi", "jordi@mail.com", "password"));
        addUser(new User(3, "Alam", LocalDate.of(2006, 1, 1), "Spanish", "alam", "alam@mail.com", "contraseña"));
        addUser(new User(4, "Joan", LocalDate.of(2006, 1, 1), "Spanish", "joan", "joan@mail.com", "contrasenya"));
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void searchUserbyUsername(String userName) {
        users.stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Usuari no trobat"));
    }

    public boolean checkUser(String checkUser) {
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(checkUser) ||
                        user.getMail().equals(checkUser));
    }

    public boolean checkPassword(String checkUser, String checkPasswd) {
        return users.stream()
                .filter(user -> user.getUsername().equals(checkUser) ||
                        user.getMail().equals(checkUser))
                .anyMatch(user -> user.getPassword().equals(checkPasswd));
    }

    public void showAllUsers() {
        users.forEach(System.out::println);
    }

    public void removeUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public List<Movie> filterMovies(String title){
        return movies.stream()
                .sorted(Comparator.comparing(a -> a.getTitle().equals(title)))
                .toList();
    }


//    System.out.print("\nVols tornar enrere? ");
//    back = sc.next();
//        if (back.equalsIgnoreCase("si")) {
//            break;
//        } else if (back.equalsIgnoreCase("no")) found = false;
//        else System.out.println("Si us plau, respongui amb “si” o “no”.");


    @Override
    public String toString() {
        return "RecomenderManager{" +
                "movies=" + movies +
                ", users=" + users +
                '}';
    }
}
