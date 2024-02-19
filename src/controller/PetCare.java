package controller;
import java.util.Scanner;
import model.Payment;
import model.PetWellness;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class PetCare {
    static Scanner sc = new Scanner(System.in);
    public void carePets(ArrayList<Object> plan, int user_id) {
        while(true) {
            String[] d = String.valueOf(plan.get(2)).split(" ");
            String dura = d[1];
            char plan_duration = '-';
            switch (dura.charAt(0)) {
                case 'h':
                System.out.print("Enter hours: ");
                plan_duration = 'h';
                break;
                case 'd' :
                System.out.print("Enter days: ");
                plan_duration = 'd';
                break;
                default :
                System.out.println("Wrong value");
                break;
            }
            int duration = sc.nextInt();
            System.out.println();
            float price = (float) plan.get(1);
            int total_duration = 0;
            float total_amount = 0;
            if(duration == Integer.parseInt(d[0])) {
                total_duration = duration;
                total_amount = price;
            }
            else {
                total_duration = Integer.parseInt(d[0]) + duration;
                total_amount = (price / 2) * total_duration;
            }
            LocalDateTime currTime = LocalDateTime.now();
            if(plan_duration == 'h') {
                currTime = currTime.plusHours(duration);
            }
            else if(plan_duration == 'd') {
                currTime = currTime.plusDays(duration);
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String currDateTime = currTime.format(formatter);
            System.out.print("Plan duration: " + d[0] + "\nPlus: " + duration + "" + Character.toUpperCase(plan_duration));
            System.out.println("Your Total Amount: " + total_amount);
            System.out.print("Enter the total amount to pay: ");
            float amt = sc.nextFloat();
            System.out.println();
            if(amt == total_amount) {
                Payment pay = new Payment();
                pay.setCurrentTime(LocalDateTime.now());
                pay.setPaymentCategory("care-pets");
                pay.setPayment_status("Successful");
                pay.setTotal_amount(total_amount);
                pay.setUser_id(user_id);
                Resource.insertData.addPayment(pay);
                int pay_id = Resource.datas.getPaymentId(user_id);
                    if(pay_id == 0) {
                        System.out.println("Errors occurs, Try again");
                        continue;
                    }
                    else {
                        PetWellness pw = new PetWellness();
                        pw.setDate(LocalDateTime.now());
                        pw.setReturnDate(currTime);
                        pw.setPayment_id(pay_id);
                        pw.setUser_id(user_id);
                        pw.setPlan_id((int) plan.get(0));
                        Resource.insertData.addPetCareRecords(pw);
                        System.out.println("Thank you for letting us to take care of your pets.");
                        System.out.println("You can get your pet on " + currDateTime);
                        return;
                    }
            }
            else continue;
        }
    }
}
