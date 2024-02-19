package controller;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

public class UserControl {
    static Scanner sc = new Scanner(System.in);
    public void availablePets(int user_id) {
        Resource.display.displayPets();
        int petchoice = Integer.parseInt(Resource.view.getUserInput("Do you want to buy? \n1.Yes  \n2.No "));
        if(petchoice == 1) {
            String pet_id = Resource.view.getUserInput("Enter pet id: ").toUpperCase();
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
    public void availablePlans(int user_id) {
        Resource.display.displayPetPlans();
        int plan_id = Integer.parseInt(Resource.view.getUserInput("What plan do you want: \nEnter plan id: "));
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
    public ArrayList<Object> login() {
        String email = Resource.view.getUserInput("Enter email: ");
        String password = Resource.view.getUserInput("Enter password: ");
        ArrayList<Object> user = Validate.login(email, password);
        if(user.isEmpty()) return new ArrayList<>();
        return user;
    }
    public void createAccount() {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String mobileRegex = "^\\d{10}$";
        String name = Resource.view.getUserInput("Enter name: ");
        String email = Resource.view.getUserInput("Enter email: ");
        if(!email.matches(emailRegex)) {
            System.out.println("Invalid email");
            return;
        }
        String pass = Resource.view.getUserInput("Enter password: ");
        String confirmPass = Resource.view.getUserInput("Enter confirm password: ");
        if(!(pass.equals(confirmPass))) {
            System.out.println("Password mismatch");
            return;
        }
        String hash = Validate.hashPassword(pass);
        String mobile = Resource.view.getUserInput("Enter mobile number: ");
        if(!mobile.matches(mobileRegex)) {
            System.out.println("Invalid mobile number");
            return;
        }
        String address = Resource.view.getUserInput("Enter address: ");
        User user = new User(name, email, hash, mobile, address);
        Resource.insertData.addUser(user);
    }
}
