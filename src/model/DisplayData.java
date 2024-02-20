package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayData extends Connect {
    public void displayPets() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM PET_DETAILS WHERE STOCK = TRUE");
            System.out.printf("%-15s %-15s %-25s %-15s %-15s %-15s %15s %15s\n", 
    "PET_ID", "PET_NAME", "BREED", "COLOUR", "GENDER", "CATEGORY", "WEIGHT", "PRICE");

            System.out.println("-".repeat(140));
            while (rs.next()) {
                System.out.printf("%-15s %-15s %-25s %-15s %-15s %-15s %15s %15s\n",  
                rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getFloat(8));
            }
        }
        catch(Exception e) {
            System.out.println("Fetch pet error " + e);
        }
    }
    public void displayPayments() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM PAYMENTS");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", 
"PAYMENT_ID", "TIME", "PAYMENT_STATUS", "TOTAL_AMOUNT", "PAYMENT_CATEGORY", "USER_ID");
            System.out.println("-".repeat(130));
            while (rs.next()) {
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getString(3) , rs.getInt(4), rs.getString(5), rs.getInt(6));
            }
        }
        catch(Exception e) {
            System.out.println("Fetch payment error " + e);
        }
    }
    public void petSellingRecords() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM PET_SELL_RECORDS");
            System.out.printf("%-20s %-20s %-20s %-20s\n", 
    "PET_ID", "USER_ID", "DATE", "PAYMENT_ID");
            System.out.println("-".repeat(80));
            while (rs.next()) {
                System.out.printf("%-20s %-20s %-20s %-20s\n", 
                rs.getString(1), rs.getInt(2), rs.getTimestamp(3).toLocalDateTime(), rs.getInt(4));
            }
        }
        catch(Exception e) {
            System.out.println("Fetch payment error " + e);
        }
    }
    public void petCareRecords() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM PETCARE_RECORDS");
            System.out.printf("%-15s %-15s %-25s %-25s %-25s\n", 
    "PLAN_ID", "USER_ID", "PAYMENT_ID", "DATE", "RETURN_DATE");
            System.out.println("-".repeat(100));
            while (rs.next()) {
                System.out.printf("%-15s %-15s %-25s %-25s %-25s\n", 
                rs.getInt(1),rs.getInt(2), rs.getInt(3), rs.getTimestamp(4), rs.getTimestamp(5));
            }
        }
        catch(Exception e) {
            System.out.println("Fetch payment error " + e);
        }
    }
    public double displayPet(String pet_id) {
        try {
            PreparedStatement p = con.prepareStatement("SELECT * FROM PET_DETAILS WHERE PET_ID = ?");
            p.setString(1, pet_id);
            ResultSet rs = p.executeQuery();
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %10s %10s\n", 
    "PET_ID", "PET_NAME", "BREED", "COLOUR", "GENDER", "CATEGORY", "WEIGHT", "PRICE");
            System.out.println("-".repeat(100));
            double price = 1;
            while (rs.next()) {
                price = rs.getDouble(8);
                System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %10s %10s\n",
                rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getFloat(8));
            }
            System.out.println(price);
            // 12 percent tax for each pet
            return (double) ((price * 12.0) / 10);
        }
        catch(Exception e) {
            System.out.println("Fetch pet error " + e);
        }
        return 0;
    }
    public void displayPetPlans() {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM PETCARE_PLANS");
            System.out.printf("%-15s %-20s %-20s  %-20s %-20s\n", 
            "PLAN_ID", "PLAN_TYPE", "PET_TYPE", "PRICE", "DURATION");


            while(rs.next()) {
                
                System.out.printf("%-15s %-20s %-21s %-21s %-21s\n", 
                rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(5), rs.getString(6));
            }
        }
        catch(Exception e) {
            System.out.println("Error while getting display plans " + e);
        }
    }
    public void displayPayment(int user_id) {
        try {
            PreparedStatement pay = con.prepareStatement("SELECT * FROM PAYMENTS WHERE USER_ID = ?");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", 
"PAYMENT_ID", "TIME", "PAYMENT_STATUS", "TOTAL_AMOUNT", "PAYMENT_CATEGORY", "USER_ID");
            System.out.println("-".repeat(120));
            pay.setInt(1, user_id);
            ResultSet rs = pay.executeQuery();
            while (rs.next()) {
                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", rs.getInt(1), rs.getTimestamp(2).toLocalDateTime(), rs.getString(3) , rs.getInt(4), rs.getString(5), rs.getInt(6));
            }
        }
        catch(Exception e) {
            System.out.println("Fetch payment error " + e);
        }
    }
    
}
