package model;

public class Pet {
    private String pet_name;
    private String breed;
    private String colour;
    private String gender;
    private String category;
    private float weight;
    private float price;
    public void setPet_name(String pet_name) {
        this.pet_name = pet_name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pet_name='" + pet_name + '\'' +
                ", breed='" + breed + '\'' +
                ", colour='" + colour + '\'' +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPet_name() {
        return pet_name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() {
        return colour;
    }

    public String getGender() {
        return gender;
    }

    public String getCategory() {
        return category;
    }

    public float getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }

    

}
