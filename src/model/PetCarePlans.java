package model;

public class PetCarePlans {
    private String plan_type;
    private String pet_type;
    private String plan_description;
    private float price;
    private String duration;
    public PetCarePlans(String plan_type, String pet_type, String plan_description, float price, String duration) {
        this.plan_type = plan_type;
        this.pet_type = pet_type;
        this.plan_description = plan_description;
        this.price = price;
        this.duration = duration;
    }

    public String getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(String plan_type) {
        this.plan_type = plan_type;
    }

    public String getPet_type() {
        return pet_type;
    }

    public void setPet_type(String pet_type) {
        this.pet_type = pet_type;
    }

    public String getPlan_description() {
        return plan_description;
    }

    public void setPlan_description(String plan_description) {
        this.plan_description = plan_description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

}
