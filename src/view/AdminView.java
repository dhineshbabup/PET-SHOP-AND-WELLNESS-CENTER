package view;
import java.util.Scanner;
import controller.Resource;

public class AdminView {
    static Scanner sc = new Scanner(System.in);
    public void adminView() {
        while(true) {
            System.out.println("1.Add pets \n2.View pets \n3.Payment Records \n4.Pet selling records  \n5.Pet care records \n6.Add Plans \n7.Modify pet stock \n8.Exit");
            int choice = sc.nextInt();
            Resource.admin.adminChoice(choice);
            return;
        }
    }
}
