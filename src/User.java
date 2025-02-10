import java.time.LocalDate;

public class User extends Person{
    private String username;
    private String mail;
    private String password;

    public User(int id, String name, LocalDate dateOfBirth, String nationality, String username, String mail, String password) {
        super(id, name, dateOfBirth, nationality);
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int id, String name, LocalDate dateOfBirth, String nationality) {
        super(id, name, dateOfBirth, nationality);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getNationality() {
        return super.getNationality();
    }

    @Override
    public void setNationality(String nationality) {
        super.setNationality(nationality);
    }

    @Override
    public String toString() {
        return super.toString() +
                "User{" +
                "username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}