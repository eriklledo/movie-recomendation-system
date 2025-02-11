import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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

    public void searchUserbyUsername(Scanner sc) {
        String searchUser = sc.next();
        for (User user : users) {
            if (user.getUsername().equals(searchUser)) {
                System.out.println(user);
            } else if (user.getMail().equals(searchUser)) {
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

    @Override
    public String toString() {
        return "RecomenderManager{" +
                "movies=" + movies +
                ", users=" + users +
                '}';
    }
}
