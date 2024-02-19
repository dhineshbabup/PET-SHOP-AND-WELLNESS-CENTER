package model;

import java.time.LocalDateTime;

public class Payment {
    public LocalDateTime currentTime;
    public String paymentCategory;
    public String payment_status;
    public double total_amount;
    public int user_id;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = LocalDateTime.now();
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double amt) {
        this.total_amount = amt;
    }

    

}
