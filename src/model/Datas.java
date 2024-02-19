package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Datas extends Connect {
    public int getPaymentId(int user_id) {
        try {
            PreparedStatement pay = con.prepareStatement("SELECT * FROM PAYMENTS WHERE USER_ID = ? ORDER BY PAYMENT_ID DESC LIMIT 1");
            pay.setInt(1, user_id);
            ResultSet rs = pay.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e) {
            System.out.println("Error on getting payment id " + e);
        }
        return 0;
    }
    public ArrayList<Object> getPlan(int plan_id) {
        ArrayList<Object> plan = new ArrayList<>();
        try {
            PreparedStatement p = con.prepareStatement("SELECT * FROM PETCARE_PLANS WHERE PLAN_ID = ?");
            p.setInt(1, plan_id);
            ResultSet rs = p.executeQuery();
            rs.next();
                plan.add(rs.getInt(1));
                plan.add(rs.getFloat(5));
                plan.add(rs.getString(6));
        }
        catch(Exception e) {
            System.out.println("Error fetching getplan" + e);
        }
        return plan;
    }
    public boolean getPetId(String pet_id) {
        try {
            PreparedStatement pet = con.prepareStatement("SELECT PET_ID FROM PET_DETAILS WHERE PET_ID = ?");
            pet.setString(1, pet_id);
            ResultSet rs = pet.executeQuery();
            return rs.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean getPlanId(int plan_id) {
        try {
            PreparedStatement plan = con.prepareStatement("SELECT PLAN_ID FROM PETCARE_PLANS WHERE PLAN_ID = ?");
            plan.setInt(1, plan_id);
            ResultSet rs = plan.executeQuery();
            return rs.next();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public ArrayList<Object> getPassword(String email) {
        ArrayList<Object> user = new ArrayList<>();
        try {
            PreparedStatement pass = con.prepareStatement("SELECT PASSWORD,USER_ID,TYPE FROM USER_DETAILS WHERE EMAIL = ?");
            pass.setString(1, email);
            ResultSet rs = pass.executeQuery();
            if(rs.next()) {
                user.add(rs.getString(1));
                user.add(rs.getInt(2));
                user.add(rs.getString(3));
            }
        }
        catch(Exception e) {
            System.out.println("Password getting error " + e);
        }
        return user;
    }
}
