package model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.sql.ResultSet;

public class InsertData extends Connect {
    static PreparedStatement pet;
    static PreparedStatement users;
    static PreparedStatement payments;
    static PreparedStatement petRecords;
    static PreparedStatement petCareRecords;
    static PreparedStatement plans;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public InsertData() throws SQLException {
        pet = con.prepareStatement("INSERT INTO PET_DETAILS(PET_ID,PET_NAME,BREED,COLOUR,GENDER,CATEGORY,WEIGHT,PRICE) VALUES(?,?,?,?,?,?,?,?)");
        users = con.prepareStatement("INSERT INTO USER_DETAILS(USER_NAME,EMAIL,PASSWORD,MOBILE_NO,ADDRESS) VALUES (?,?,?,?,?)");
        payments = con.prepareStatement("INSERT INTO PAYMENTS(TIME, PAYMENT_STATUS, TOTAL_AMOUNT, PAYMENT_CATEGORY, USER_ID) VALUES(?,?,?,?,?)");
        petRecords = con.prepareStatement("INSERT INTO PET_SELL_RECORDS(PET_ID, USER_ID, DATE, PAYMENT_ID) VALUES(?,?,?,?)");
        petCareRecords = con.prepareStatement("INSERT INTO PETCARE_RECORDS(PLAN_ID, USER_ID, PAYMENT_ID, DATE, RETURN_DATE) VALUES(?,?,?,?,?);");
        plans = con.prepareStatement("INSERT INTO PETCARE_PLANS(PLAN_TYPE,PET_TYPE,PLAN_DESCRIPTION,PRICE,DURATION) VALUES(?,?,?,?,?)");
    }
    public String generatePetId(String s1, String s2, String s3) {
        return  s1.substring(0, 2).toUpperCase() + s2.substring(0, 2).toUpperCase() + s3.substring(0,2).toUpperCase();
    }
    public void addPet(Pet newPet) {
        try {
            String pet_id =generatePetId(newPet.getPet_name(), newPet.getColour(), newPet.getCategory());
            PreparedStatement p = con.prepareStatement("Select * from PET_DETAILS where pet_id = ?");
            p.setString(1, pet_id);
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                System.out.println("Pet Already exist in inventry");
                return;
            }
            pet.setString(1, pet_id);
            pet.setString(2, newPet.getPet_name());
            pet.setString(3, newPet.getBreed());
            pet.setString(4, newPet.getColour());
            pet.setString(5, newPet.getGender());
            pet.setString(6, newPet.getCategory());
            pet.setDouble(7, newPet.getWeight());
            pet.setDouble(8, newPet.getPrice());
            pet.executeUpdate();
            System.out.println("Pet Added");
        }
        catch(Exception e) {
            System.out.println("Error while Adding pets " + e);
        }
    }
    public void addUser(User user) {
        try {
            PreparedStatement p = con.prepareStatement("SELECT * FROM USER_DETAILS WHERE EMAIL = ? AND MOBILE_NO = ?");
            p.setString(1, user.getEmail());
            p.setString(2, user.getMobile_no());
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                System.out.println("User Already Exist");
                return;
            }
            users.setString(1, user.getName());
            users.setString(2, user.getEmail());
            users.setString(3, user.getPassword());
            users.setString(4, user.getMobile_no());
            users.setString(5, user.getAddress());
            users.executeUpdate();
            System.out.println("Account created, Now you can login");
        }
        catch(Exception e) {
            System.out.println("Error while adding user " + e);
        }
    }
    public void addPayment(Payment pay) {
        try {
            String fd = pay.getCurrentTime().format(formatter);
            payments.setObject(1, fd);
            payments.setString(2, pay.getPayment_status());
            payments.setDouble(3, pay.getTotal_amount());
            payments.setString(4, pay.getPaymentCategory());
            payments.setInt(5, pay.getUser_id());
            payments.executeUpdate();
            System.out.println("payment sucessful...");
        }
        catch(Exception e) {
            System.out.println("Error while adding payment " + e);
        }
    }
    public void addPetRecords(PetSell ps) {
        try {
            petRecords.setString(1, ps.getPet_id());
            petRecords.setInt(2, ps.getUser_id());
            String fd = ps.getDate().format(formatter);
            petRecords.setObject(3, fd);
            petRecords.setInt(4, ps.getPayment_id());
            petRecords.executeUpdate();
        }
        catch(Exception e) {
            System.out.println("Error while adding pet records " + e);
        }
    }
    public void addPetCareRecords(PetWellness pw) {
        try {
            
            petCareRecords.setInt(1, pw.getPlan_id());
            petCareRecords.setInt(2, pw.getUser_id());
            petCareRecords.setInt(3, pw.getPayment_id());
            petCareRecords.setObject(4, pw.getDate());
            petCareRecords.setObject(5, pw.getReturnDate());
            petCareRecords.executeUpdate();

        }
        catch(Exception e) {
            System.out.println("Error in adding pet care records " + e);
        }
    }
    public void addPlan(PetCarePlans pcp) {
        try {
            plans.setString(1, pcp.getPlan_type());
            plans.setString(2, pcp.getPet_type());
            plans.setString(3, pcp.getPlan_description());
            plans.setFloat(4, pcp.getPrice());
            plans.setString(5, pcp.getDuration());
            plans.executeUpdate();
            System.out.println("Plan added...\n");
        }
        catch(Exception e) {
            System.out.println("Error while adding plans " + e);
        }
    }
}
