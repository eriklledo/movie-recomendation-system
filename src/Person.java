import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Locale;

public class Person {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String nationality;

    public Person(int id, String name, LocalDate dateOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
