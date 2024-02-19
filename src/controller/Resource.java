package controller;
import java.sql.SQLException;



import model.Update;
import view.AdminView;
import view.UserView;
import model.Datas;
import model.DeleteData;
import model.DisplayData;
import model.InsertData;

public class Resource {
    public static DisplayData display;
    public static InsertData insertData;
    public static Datas datas;
    public static Admin admin;
    public static DeleteData delete;
    public static UserControl userControl;
    public static Update update;
    public static UserView userView;
    public static AdminView adminView;
    public static void init() throws SQLException {
        display = new DisplayData();
        insertData = new InsertData();
        datas = new Datas();
        admin = new Admin();
        delete = new DeleteData();
        userControl = new UserControl();
        update = new Update();
        userView = new UserView();
        adminView = new AdminView();
    }
}
