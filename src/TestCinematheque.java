import java.util.ArrayList;

public class TestCinematheque {
    public static void main(String[] args) {
        Cinematheque cinematheque = new Cinematheque();

        // Inception
        ArrayList<Director> directors = new ArrayList<>();
        ArrayList<Actor> actors = new ArrayList<>();

        Film inception = new Film("Inception", directors, actors, "Action", 2010, 148);
        cinematheque.getFilms().add(inception);

        Actor leonardoDiCaprio = new Actor("Leonardo DiCaprio", 1974, "Male", "U.S.");
        Actor josephGordonLevitt = new Actor("Joseph Gordon-Levitt", 1981, "Male", "U.S.");
        Actor kenWatanabe = new Actor("Ken Watanabe", 1959, "Male", "Japanese");

        inception.addActor(leonardoDiCaprio);
        inception.addActor(josephGordonLevitt);
        inception.addActor(kenWatanabe);

        Director christopherNolan = new Director("Christopher Nolan", 1970, "Male", "British");
        inception.addDirector(christopherNolan);

        System.out.println("FILM BROWSER: ");
        cinematheque.searchByDirector();
        cinematheque.searchByGenre();
        cinematheque.displayAllFilms();
    }
}
