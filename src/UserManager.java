import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserManager {
    private Set<Movie> movies;
    private Set<User> users;

    public UserManager(Set<Movie> movies, Set<User> users) {
        this.movies = new HashSet<>();
        this.users = new HashSet<>();
    }

    public UserManager() {
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
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername())) users.add(user);
            else System.out.println("L'usuari ja existeix");
        }
    }

    public void searchUserbyName(Scanner sc) {
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
        return users.stream().anyMatch(user -> user.getName().equals(checkUser));
    }

    public boolean checkPassword(String checkPasswd) {
        return users.stream().anyMatch(user -> user.getPassword().equals(checkPasswd));
    }


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
