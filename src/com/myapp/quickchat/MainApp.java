import com.myapp.quickchat.Login;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("Register User");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter phone (+27...): ");
        String phone = input.nextLine();

        System.out.println(login.registerUser(username, password, phone));

        System.out.println("\nLogin");

        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean success = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(success));
    }
}
