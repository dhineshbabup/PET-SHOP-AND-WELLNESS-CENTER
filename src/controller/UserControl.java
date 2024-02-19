package controller;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class UserControl {
    static Scanner sc = new Scanner(System.in);
    public ArrayList<Object> login() {
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        ArrayList<Object> user = Validate.login(email, password);
        if(user.isEmpty()) return new ArrayList<>();
        return user;
    }
    public void createAccount() {
        User user = new User();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String mobileRegex = "^\\d{10}$";
        System.out.print("Enter name: ");
        user.setName(sc.nextLine());
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        if(!email.matches(emailRegex)) {
            System.out.println("Invalid email");
            return;
        }
        user.setEmail(email);
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        System.out.print("Enter confirm password: ");
        String confirmPass = sc.nextLine();
        if(!(pass.equals(confirmPass))) {
            System.out.println("Password mismatch");
            return;
        }
        user.setPassword(Validate.hashPassword(pass));
        System.out.print("Enter mobile number: ");
        String mobile = sc.nextLine();
        if(!mobile.matches(mobileRegex)) {
            System.out.println("Invalid mobile number");
            return;
        }
        user.setMobile_no(mobile);
        System.out.print("Enter address: ");
        user.setAddress(sc.nextLine());
        Resource.insertData.addUser(user);
    }
}
