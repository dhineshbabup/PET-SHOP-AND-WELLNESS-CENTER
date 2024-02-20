package model;

import java.time.LocalDateTime;

public class PetSell {
    public int user_id;
    public String pet_id;
    public int payment_id;
    private LocalDateTime date;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPet_id() {
        return pet_id;
    }

    public void setPet_id(String pet_id2) {
        this.pet_id = pet_id2;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = LocalDateTime.now();
    }
}
