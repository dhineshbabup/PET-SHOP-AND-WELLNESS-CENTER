package view;
import java.util.ArrayList;
import java.util.Scanner;
import controller.BuyPets;
import controller.PetCare;
import controller.Resource;
import controller.Validate;

public class UserView {
    static Scanner sc = new Scanner(System.in);
    public void userView(int user_id) {
        System.out.println("1. To see available pets. ");
        System.out.println("2. To see our pet care plans. ");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        if(choice == 1) {
            Resource.display.displayPets();
            System.out.println("Do you want to buy? \n1.Yes  \n2.No ");
            int petchoice = sc.nextInt();
            if(petchoice == 1) {
                System.out.print("Enter pet id: ");
                String pet_id = sc.next().toUpperCase();
                if(Validate.checkPet(pet_id)) {
                    System.out.println();
                    BuyPets b = new BuyPets();
                    b.buyPets(pet_id, user_id);
                }
                else {
                    System.out.println("Invalid pet id, Try Agin...");
                    return;
                }
            }
            else {
                return;
            }
        }
        else if(choice == 2) {
            Resource.display.displayPetPlans();
            System.out.print("What plan do you want: \nEnter plan id: ");
            int plan_id = sc.nextInt();
            // validate plan id
            if(Validate.checkPlan(plan_id)) {
                PetCare pc = new PetCare();
                ArrayList<Object> plan = Resource.datas.getPlan(plan_id);
                if(plan.size() > 0)
                pc.carePets(plan, user_id);
            }
            else {
                System.out.println("Invalid plan id, Try again...");
            }
        }
        else if(choice == 3) {
            return;
        }
        else {
            System.out.println("Invalid choice");
            return;
        }
    }
}
