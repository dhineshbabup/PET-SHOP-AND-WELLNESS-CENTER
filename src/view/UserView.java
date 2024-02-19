package view;
import java.util.Scanner;
import controller.Resource;

public class UserView {
    static Scanner sc = new Scanner(System.in);
    public void userView(int user_id) {
        while(true) {
        System.out.println("1. To see available pets. ");
        System.out.println("2. To see our pet care plans. ");
        System.out.println("3. To see your payments. ");
        System.out.println("4. Exit");
        int choice = sc.nextInt();
        if(choice == 1) {
            Resource.userControl.availablePets(user_id);
        }
        else if(choice == 2) {
            Resource.userControl.availablePlans(user_id);
        }
        else if(choice == 3) {
            Resource.display.displayPayment(user_id);
        }
        else if(choice == 4) {
            return;
        }
        else {
            System.out.println("Invalid choice");
            return;
        }
    }
}
}
