package controller;
import java.util.Scanner;
import model.Pet;
import model.PetCarePlans;

public class Admin {
    static Scanner sc = new Scanner(System.in);
    public void addPets() {
        Pet newPet = new Pet();
        System.out.print("Enter pet name: ");
        newPet.setPet_name(sc.nextLine());
        System.out.print("Enter breed: ");
        newPet.setBreed(sc.nextLine());
        System.out.print("Enter colour: ");
        newPet.setColour(sc.nextLine());
        System.out.print("Enter gender: ");
        newPet.setGender(sc.nextLine());
        System.out.print("Enter pet category: ");
        newPet.setCategory(sc.nextLine());
        System.out.print("Enter price: ");
        newPet.setPrice(sc.nextFloat());
        System.out.print("Enter weight: ");
        newPet.setWeight(sc.nextFloat());
        Resource.insertData.addPet(newPet);
    }
    public void deletePet() {
        System.out.print("Enter pet id: ");
        String pet_id = sc.nextLine();
        System.out.println(pet_id);
        Resource.delete.deletePet(pet_id);
    }
    public void addPlan() {
        PetCarePlans pcp = new PetCarePlans();
        System.out.print("Enter plan type: ");
        pcp.setPlan_type(sc.nextLine());
        System.out.print("Enter pet type: ");
        pcp.setPet_type(sc.nextLine());
        System.out.print("Enter plan description: ");
        pcp.setPlan_description(sc.nextLine());
        System.out.print("Enter price: ");
        pcp.setPrice(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter duration: ");
        pcp.setDuration(sc.nextLine());
        Resource.insertData.addPlan(pcp);
    }
}
