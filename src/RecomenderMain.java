import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecomenderMain {
    public static void main(String[] args) {
        RecomenderManager rM = new RecomenderManager();
        Scanner sc = new Scanner(System.in);

        boolean inMenu = true;

        while(inMenu){
            System.out.print("""
                    
                    RECOMANADOR DE PEL·LÍCULES
                    
                    Trieu una opció
                    1. Crear usuari
                    2. Iniciar sessió
                    3, Sortir de programa
                   
                    Triï una opció:
                    """);
            int option = sc.nextInt();
            sc.nextLine();


            switch(option){
                case 1:
                    System.out.print("Introdueixi el seu correu: ");
                    System.out.print("Introdueixi un nom d'usuari: ");
                    System.out.print("Introdueixi un contrasenya: ");
                    System.out.print("Repeteix la contrasenya: ");
                    break;
                case 2:
                    System.out.print("Introdueixi el seu correu: ");
                    System.out.print("Introdueixi un nom d'usuari: ");
                    System.out.print("Introdueixi un contrasenya: ");
                    break;
                case 3:
                    inMenu = false;
                    break;


            }

        }

    }


    public static boolean MailChecking(String mail) {

        Pattern verifyEmail = Pattern.compile("([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)");
        Matcher search = verifyEmail.matcher(mail);
        return search.find();
    }

    public static boolean PasswordChecking(String password) {

        Pattern securePassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        Matcher search = securePassword.matcher(password);
        return search.find();

    }

    public static void defaultUsers() {
        User erik = new User(1, "Èrik", LocalDate.of(2004,10,15), "Spanish");
    }

    public static User createUser(Scanner sc){
        System.out.println();
        String name = sc.nextLine();
        System.out.println();
        String userName = sc.nextLine();
        System.out.println();
        String email = sc.nextLine();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        return
    }

}
