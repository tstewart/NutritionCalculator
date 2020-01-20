package io.github.tstewart.NutritionCalculator;

public class UserInfo {
    private Gender gender;
    private int age;
    private double weight;
    private double height;

    public UserInfo(Gender gender, int age, double weight, double height) {

        if(gender == null) throw new IllegalArgumentException("Please select a gender");
        if(age < 0 || age > 120) throw new IllegalArgumentException("Invalid age (min 0, max 120)");
        if(weight < 0 || weight > 500) throw new IllegalArgumentException("Invalid weight (min 0kg, max 500kg)");
        if(height < 0 || height > 250) throw new IllegalArgumentException("Invalid height (min 0cm, max 250cm");

        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}

