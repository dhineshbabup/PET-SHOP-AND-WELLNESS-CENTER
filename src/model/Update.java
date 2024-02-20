package model;

import java.sql.PreparedStatement;

public class Update extends Connect {
    public void updatePetStock(String pet_id) {
        try {
            PreparedStatement pet = con.prepareStatement("UPDATE PET_DETAILS SET STOCK = FALSE WHERE PET_ID = ?");
            pet.setString(1, pet_id);
            int row = pet.executeUpdate();
            System.out.println(row > 0 ? " " : "Invalid pet id");
        }
        catch(Exception e) {
            System.out.println("error while update stock " + e);
        }
    }
}
