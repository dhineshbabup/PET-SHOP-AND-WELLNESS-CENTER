package view;
import java.util.Scanner;
import controller.Resource;

public class AdminView {
    static Scanner sc = new Scanner(System.in);
    public void adminView() {
        while(true) {
            System.out.println("1.Add pets \n2.View pets \n3.Payment Records \n4.Pet selling records  \n5.Pet care records \n6.Add Plans \n7.Modify pet stock \n8.Exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    Resource.admin.addPets();
                    break;
                case 2:
                    Resource.display.displayPets();
                    break;
                case 3:
                    Resource.display.displayPayments();
                    break;
                case 4:
                    Resource.display.petSellingRecords();
                    break;
                case 5:
                    Resource.display.petCareRecords();
                    break;
                case 6:
                    Resource.admin.addPlan();
                    break;
                case 7:
                    System.out.print("Enter pet id: ");
                    sc.nextLine();
                    Resource.update.updatePetStock(sc.nextLine());
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice...\n \n");
                    break;
            }
        }
    }
}
