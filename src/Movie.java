import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Movie {
    private int id;
    private String title;
    private Set<Director> directors;
    private Set<Actor> actors;
    private Set<String> genre;
    private Year year;

    public Movie(int id, String title, Year year) {
        this.id = id;
        this.title = title;
        directors = new HashSet<>();
        actors = new HashSet<>();
        genre = new HashSet<>();
        this.year = year;
    }

    public Movie(int id, String title, Set<Director>directors, Set<Actor>actors, Set<String> genre, Year year) {
        this.id = id;
        this.title = title;
        this.directors = directors;
        this.actors = actors;
        this.genre = genre;
        this.year = year;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<String> getGenre() {
        return genre;
    }

    public void setGenre(Set<String> genre) {
        this.genre = genre;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Títol: " + title + "\n" +
                "Gènere: " + String.join(", ", genre) + "\n" +
                "Director(s): " + directors.stream()
                .map(Director::getName)
                .collect(Collectors.joining(", ")) + "\n" +
                "Actors Principals: " + actors.stream()
                .map(Actor::getName)
                .collect(Collectors.joining(", ")) + "\n" +
                "Any: " + year + "\n";
    }

}
