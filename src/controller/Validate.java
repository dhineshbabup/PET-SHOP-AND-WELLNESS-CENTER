package controller;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;
public class Validate {

    protected boolean checkPet(String pet_id) {
        return Resource.datas.getPetId(pet_id);
    }
    protected boolean checkPlan(int plan_id) {
        return Resource.datas.getPlanId(plan_id);
    }
    
    protected ArrayList<Object> getHashPassword(String email) {
        return Resource.datas.getPassword(email);
    }
    protected boolean checkPassword(String h, String p) {
        return BCrypt.checkpw(p, h);
    }
    protected String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    protected ArrayList<Object> login(String email, String password) {
        ArrayList<Object> user = getHashPassword(email);
        if(user.isEmpty()) {
            System.out.println("Invalid email");
            return new ArrayList<>();
        }
        boolean isCorrect = checkPassword((String)user.get(0), password);
        if(isCorrect) {
            System.out.println("Login Successful");
            return user;
        }
        System.out.println("Invalid password");
        return new ArrayList<>();
    }
}
