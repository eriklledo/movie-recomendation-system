import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Movie {
    private int id;
    private String title;
    private Set<Director> directors;
    private Set<Actor> actors;
    private Set<String> genre;
    private Year year;

    public Movie(Year year, String title, int id) {
        this.year = year;
        this.title = title;
        this.id = id;
        directors = new HashSet<>();
        actors = new HashSet<>();
        genre = new HashSet<>();
    }

    public Movie(Year year, String title, int id, Set<Director>directors, Set<Actor>actors, Set<String> genre) {
        this.year = year;
        this.title = title;
        this.id = id;
        this.directors = directors;
        this.actors = actors;
        this.genre = genre;
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
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", directors=" + directors +
                ", actors=" + actors +
                ", genre=" + genre +
                ", year=" + year +
                '}';
    }
}
