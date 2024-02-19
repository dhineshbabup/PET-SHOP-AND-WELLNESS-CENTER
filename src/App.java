import model.Connect;
import view.Viewer;
import java.util.ArrayList;
import java.util.Scanner;
import controller.Resource;
public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Connect.getConnection();
        Resource.init();
        ArrayList<Object> user = new ArrayList<>();
        while(true) {
            System.out.println("Welcome to our pet shop");
            System.out.println("1.Login \n2.Create new acoount \n3.Press any number to exit");
            int choice = sc.nextInt();
            if(choice == 1) {
                user = Resource.userControl.login();
                if(user.isEmpty()) continue;
                Viewer.start((int)user.get(1), (String) user.get(2));
                break;
            }
            else if(choice == 2) {
                Resource.userControl.createAccount();
            }
            else {
                break;
            }
        }
    }
}