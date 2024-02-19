package model;

import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
public class Connect {
    protected static Connection con;
    protected static Statement statement;
    public static void getConnection() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PET_SHOP","root","DHINESHp_4029");
            statement = con.createStatement();
        }
        catch(Exception e) {
            System.out.println("Connection Error" + e);
        }
    }
}
