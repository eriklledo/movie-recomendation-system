import java.util.*;

public class MovieRecomendationManager {
    private Set<Movie> movies;
    private Set<User> users;

    public MovieRecomendationManager() {
        this.movies = new HashSet<>();
        this.users = new HashSet<>();
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
        for (User user : users) {
            if (user.getUsername().equals(userName)) {
                System.out.println(user);
            } else if (user.getMail().equals(userName)) {
                System.out.println(user);

            } else {
                System.out.println("Usuari no trobat.");
            }
        }
    }

    public boolean checkUser(String checkUser) {
        return users.stream().anyMatch(user -> user.getUsername().equals(checkUser));
    }

    public boolean checkPassword(String checkUser, String checkPasswd) {
        return users.stream()
                .filter(user -> user.getUsername().equals(checkUser))
                .anyMatch(user -> user.getPassword().equals(checkPasswd));    }


    public void showAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
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
