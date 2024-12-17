import java.util.ArrayList;

public class Film {
    private String title;
    private ArrayList<Director> directors;
    private ArrayList<Actor> actors;
    private String genre;
    private int year;
    private int duration;

    public Film(String title, ArrayList<Director> directors, ArrayList<Actor> actors, String genres, int year, int duration) {
        this.title = title;
        this.directors = directors;
        this.actors = actors;
        this.genre = genres;
        this.year = year;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<Director> directors) {
        this.directors = directors;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public void addDirector(Director director) {
        this.directors.add(director);
    }

    @Override
    public String toString() {
        return title +
                "\n  Director: " + directors +
                "\n  Actors: " + actors +
                "\n  Genres: " + genre +
                "\n  Year: " + year +
                "\n  Duration: " + duration;
    }
}
