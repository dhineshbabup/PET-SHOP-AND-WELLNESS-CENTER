package controller;
import model.Payment;
import model.PetWellness;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class PetCare {
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
            int duration = Integer.parseInt(Resource.view.getUserInput(""));
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
            System.out.println("Plan duration: " + d[0] + "\nPlus: " + duration + "" + Character.toUpperCase(plan_duration));
            System.out.println("Your Total Amount: " + total_amount);
            float amt = Float.parseFloat(Resource.view.getUserInput("Enter the total amount to pay: "));
            System.out.println();
            if(amt == total_amount) {
                payment(total_amount, user_id, currTime, (int) plan.get(0), currDateTime);
                return;
            }
            else continue;
        }
    }
    public void payment(double total_amount, int user_id, LocalDateTime currTime, int plan_id, String currDateTime) {
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
                return;
            }
            else {
                PetWellness pw = new PetWellness();
                pw.setDate(LocalDateTime.now());
                pw.setReturnDate(currTime);
                pw.setPayment_id(pay_id);
                pw.setUser_id(user_id);
                pw.setPlan_id(plan_id);
                Resource.insertData.addPetCareRecords(pw);
                System.out.println("Thank you for letting us to take care of your pets.");
                System.out.println("You can get your pet on " + currDateTime);
                return;
            }

    }
}
