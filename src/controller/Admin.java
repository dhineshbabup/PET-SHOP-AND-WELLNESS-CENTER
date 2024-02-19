package controller;
import java.util.Scanner;

import model.Pet;
import model.PetCarePlans;

public class Admin {
    static Scanner sc = new Scanner(System.in);
    public void adminChoice(int choice) {
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
                Resource.admin.updateStock();
                break;
            case 8:
                return;
            default:
                System.out.println("Invalid choice...\n \n");
                return;
        }
    }
    public void addPets() {
        String name = Resource.view.getUserInput("Enter pet name: ");
        String breed = Resource.view.getUserInput("Enter breed: ");
        String colour = Resource.view.getUserInput("Enter colour: ");
        String gender = Resource.view.getUserInput("Enter gender: ");
        String category = Resource.view.getUserInput("Enter pet category: ");
        float price = Float.parseFloat(Resource.view.getUserInput("Enter price: "));
        float weight = Float.parseFloat(Resource.view.getUserInput("Enter weight: "));
        Pet newPet = new Pet(name, breed, colour, gender, category, weight, price);
        Resource.insertData.addPet(newPet);
    }
    public void addPlan() {
        String plan_type = Resource.view.getUserInput("Enter plan type: ");
        String pet_type = Resource.view.getUserInput("Enter pet type: ");
        String description = Resource.view.getUserInput("Enter plan description: ");
        float price = Float.parseFloat(Resource.view.getUserInput("Enter price: "));
        String duration = Resource.view.getUserInput("Enter duration: ");
        PetCarePlans pcp = new PetCarePlans(plan_type,pet_type,description, price, duration);
        System.out.println(pcp.toString());
        Resource.insertData.addPlan(pcp);
    }
    public void updateStock() {
        Resource.update.updatePetStock(Resource.view.getUserInput("Enter pet id: "));
    }
}