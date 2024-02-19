package controller;
import java.time.LocalDateTime;
import java.util.Scanner;
import model.Payment;
import model.PetSell;

public class BuyPets {
    static Scanner sc = new Scanner(System.in);
    public void buyPets(String pet_id, int user_id) {
        double price = Resource.display.displayPet(pet_id);
        System.out.println();
        System.out.println("Total Price with tax: " + price);
        System.out.print("1. Confirm buy? \n2. Cancel\n");
        int payment = sc.nextInt();
        while(true) {
            if(payment == 1) {
                System.out.print("Proceeded to pay -> Enter total amount: ");
                double amt = sc.nextDouble();
                System.out.println();
                if(amt == price) {
                    Payment pay = new Payment();
                    pay.setCurrentTime(LocalDateTime.now());
                    pay.setUser_id(user_id);
                    pay.setPaymentCategory("buying-pets");
                    pay.setPayment_status("Successful");
                    pay.setTotal_amount(amt);
                    Resource.insertData.addPayment(pay);
                    int pay_id = Resource.datas.getPaymentId(user_id);
                    if(pay_id == 0) {
                        System.out.println("Errors occurs, Try again");
                        continue;
                    }
                    else {
                        PetSell ps = new PetSell();
                        ps.setPet_id(pet_id);
                        ps.setUser_id(user_id);
                        ps.setPayment_id(pay_id);
                        ps.setDate(LocalDateTime.now());
                        Resource.insertData.addPetRecords(ps);
                        Resource.update.updatePetStock(pet_id);
                        System.out.println("Thanks for purchasing");
                        return;
                    }
                }
                else continue;
            }
            else {
                break;
            }
        }
    }
}
