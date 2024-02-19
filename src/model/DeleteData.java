package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData extends Connect {
    static PreparedStatement delePet;
    public DeleteData() throws SQLException {
        delePet = con.prepareStatement("DELETE FROM PET_DETAILS WHERE PET_ID = ?");
    }
    public void deletePet(String pet_id) {
        try {
            delePet.setString(1, pet_id);
            int rows = delePet.executeUpdate();
            if(rows > 0) {
                System.out.println("pet removed...");
            }
        }
        catch(Exception e) {
            System.out.println("error while delete pet " + e);
        }
    }
}
