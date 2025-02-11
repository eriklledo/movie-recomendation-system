import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class MovieRecomendationManager {
    private Set<Movie> movies;
    private Set<User> users;

    public MovieRecomendationManager(Set<Movie> movies, Set<User> users) {
        this.movies = new HashSet<>();
        this.users = new HashSet<>();
    }

    public MovieRecomendationManager() {
        movies = new HashSet<>();
        users = new HashSet<>();
//        addDefaultMovies();
    }

//
//    private void addDefaultMovies() {
//        movies.add(new Movie(Year.of(2010), "Inception", 1,
//                Set.of(new Director("Christopher Nolan")),
//                Set.of(new Actor("Leonardo DiCaprio"), new Actor("Joseph Gordon-Levitt"), new Actor("Ken Watanabe")),
//                Set.of("Action", "Adventure", "Science Fiction")
//        ));
//
//        movies.add(new Movie(Year.of(1972), "The Godfather", 2,
//                Set.of(new Director("Francis Ford Coppola")),
//                Set.of(new Actor("Marlon Brando"), new Actor("Al Pacino"), new Actor("James Caan"), new Actor("Robert Duvall")),
//                Set.of("Crime", "Drama")
//        ));
//
//        movies.add(new Movie(Year.of(1994), "Pulp Fiction", 3,
//                Set.of(new Director("Quentin Tarantino")),
//                Set.of(new Actor("John Travolta"), new Actor("Samuel L. Jackson"), new Actor("Uma Thurman"), new Actor("Bruce Willis")),
//                Set.of("Crime", "Thriller")
//        ));
//
//        movies.add(new Movie(Year.of(2019), "Joker", 4,
//                Set.of(new Director("Todd Phillips")),
//                Set.of(new Actor("Joaquin Phoenix"), new Actor("Robert De Niro"), new Actor("Zazie Beetz")),
//                Set.of("Crime", "Drama", "Thriller")
//        ));
//
//        movies.add(new Movie(Year.of(2012), "Django Unchained", 5,
//                Set.of(new Director("Quentin Tarantino")),
//                Set.of(new Actor("Jamie Foxx"), new Actor("Christoph Waltz"), new Actor("Leonardo DiCaprio"),
//                        new Actor("Kerry Washington"), new Actor("Samuel L. Jackson"), new Actor("Walton Goggins")),
//                Set.of("Western")
//        ));
//
//        movies.add(new Movie(Year.of(1976), "Taxi Driver", 6,
//                Set.of(new Director("Martin Scorsese")),
//                Set.of(new Actor("Robert De Niro"), new Actor("Jodie Foster"), new Actor("Cybill Shepherd"), new Actor("Harvey Keitel")),
//                Set.of("Drama", "Crime")
//        ));
//
//        movies.add(new Movie(Year.of(1991), "The Silence of the Lambs", 7,
//                Set.of(new Director("Jonathan Demme")),
//                Set.of(new Actor("Jodie Foster"), new Actor("Anthony Hopkins"), new Actor("Scott Glenn"), new Actor("Ted Levine")),
//                Set.of("Horror", "Crime", "Thriller", "Drama")
//        ));
//
//        movies.add(new Movie(Year.of(1990), "GoodFellas", 8,
//                Set.of(new Director("Martin Scorsese")),
//                Set.of(new Actor("Robert De Niro"), new Actor("Ray Liotta"), new Actor("Joe Pesci"), new Actor("Lorraine Bracco")),
//                Set.of("Drama", "Crime")
//        ));
//
//        movies.add(new Movie(Year.of(2014), "Interstellar", 9,
//                Set.of(new Director("Christopher Nolan")),
//                Set.of(new Actor("Matthew McConaughey"), new Actor("Anne Hathaway"), new Actor("Michael Caine")),
//                Set.of("Science Fiction", "Drama", "Adventure")
//        ));
//
//        movies.add(new Movie(Year.of(2006), "The Devil Wears Prada", 10,
//                Set.of(new Director("David Frankel")),
//                Set.of(new Actor("Meryl Streep"), new Actor("Anne Hathaway"), new Actor("Emily Blunt"), new Actor("Stanley Tucci")),
//                Set.of("Comedy", "Drama")
//        ));
//
//        movies.add(new Movie(Year.of(2023), "Killers of the Flower Moon", 11,
//                Set.of(new Director("Martin Scorsese")),
//                Set.of(new Actor("Leonardo DiCaprio"), new Actor("Robert De Niro"), new Actor("Lily Gladstone")),
//                Set.of("History", "Crime", "Drama")
//        ));
//
//        movies.add(new Movie(Year.of(1960), "Psycho", 12,
//                Set.of(new Director("Alfred Hitchcock")),
//                Set.of(new Actor("Anthony Perkins"), new Actor("Janet Leigh"), new Actor("Vera Miles"), new Actor("John Gavin")),
//                Set.of("Mystery", "Thriller", "Horror")
//        ));
//
//        movies.add(new Movie(Year.of(1999), "Eyes Wide Shut", 13,
//                Set.of(new Director("Stanley Kubrick")),
//                Set.of(new Actor("Tom Cruise"), new Actor("Nicole Kidman"), new Actor("Sydney Pollack")),
//                Set.of("Thriller", "Drama", "Mystery")
//        ));
//    }



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


    public LinkedHashSet<Movie> filterMovies(String query) {
        query = query.toLowerCase();

        String finalQuery = query;
        return movies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(finalQuery) ||
                        movie.getYear().toString().contains(finalQuery) ||
                        movie.getDirectors().stream().anyMatch(d -> d.getName().toLowerCase().contains(finalQuery)) ||
                        movie.getActors().stream().anyMatch(a -> a.getName().toLowerCase().contains(finalQuery)) ||
                        movie.getGenre().stream().anyMatch(g -> g.toLowerCase().contains(finalQuery)))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


    public void listMovies(){
        for (Movie m: movies){
            System.out.println(m);
        }
    }


    @Override
    public String toString() {
        return "RecomenderManager{" +
                "movies=" + movies +
                ", users=" + users +
                '}';
    }
}
