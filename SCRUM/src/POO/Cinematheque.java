package POO;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinematheque {
    private ArrayList<Film> films;

    public Cinematheque() {
        this.films = new ArrayList<>();
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public void searchByDirector() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSearch by director: ");
        String searchByDirector = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Film film : films) {
            for (Director director : film.getDirectors()) {
                if (director.getName().toLowerCase().contains(searchByDirector)) {
                    System.out.println(film);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No movies found for this director.");
        }
    }

    public void searchByGenre() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nSearch by genre: ");
        String searchByGenre = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Film film : films) {
            if (film.getGenre().toLowerCase().contains(searchByGenre)) {
                System.out.println(film);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No movies found for this genre.");
        }

    }

    public void displayAllFilms() {
        System.out.println("\nFILM LIST: ");

        for (Film film : films) {
            System.out.println(film);
        }
    }

    @Override
    public String toString() {
        return "Cinematheque{" +
                "films=" + films +
                '}';
    }
}
