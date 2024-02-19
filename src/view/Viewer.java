package view;
import java.sql.SQLException;
import java.util.Scanner;
import controller.Resource;
public class Viewer {
    static Scanner sc = new Scanner(System.in);
    public static void start(int user_id, String type) throws SQLException {
        Resource.init();
        if(type.equals("user")) {
            Resource.userView.userView(user_id);
            return;
        }
        else if(type.equals("admin")) {
            Resource.adminView.adminView();
            return;
        }
    }
}
