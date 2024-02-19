package model;

public class PetCarePlans {
    private String plan_type;
    private String pet_type;
    private String plan_description;
    private float price;
    private String duration;

   
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

    @Override
    public String toString() {
        return "PetCarePlans{" +
                ", plan_type='" + plan_type + '\'' +
                ", pet_type='" + pet_type + '\'' +
                ", plan_description='" + plan_description + '\'' +
                ", price=" + price +
                ", duration='" + duration + '\'' +
                '}';
    }
}
