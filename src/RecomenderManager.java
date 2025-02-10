import java.util.Set;

public class RecomenderManager {
    private Set<Movie> movies;
    private Set<User> users;

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

    public void showAllUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void removeUserById(int id) {
        users.removeIf(book -> book.getId() == id);
    }



    @Override
    public String toString() {
        return "RecomenderManager{" +
                "movies=" + movies +
                ", users=" + users +
                '}';
    }
}
