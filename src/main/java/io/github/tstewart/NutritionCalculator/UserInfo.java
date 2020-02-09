package io.github.tstewart.NutritionCalculator;

import io.github.tstewart.NutritionCalculator.strategies.NutritionCalculationStrategy;

public class UserInfo {
    private Gender gender;
    private int age;
    private double weight;
    private double height;
    private UserNutrition userNutrition;

    public UserInfo(Gender gender, int age, double weight, double height) throws IllegalArgumentException {

        if(gender == null) throw new IllegalArgumentException("Please select a gender");
        if(age < 0 || age > 120) throw new IllegalArgumentException("Invalid age (min 0, max 120)");
        if(weight < 0 || weight > 500) throw new IllegalArgumentException("Invalid weight (min 0kg, max 500kg)");
        if(height < 0 || height > 250) throw new IllegalArgumentException("Invalid height (min 0cm, max 250cm");

        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;

        NutritionCalculationStrategy calculationStrategy = new NutritionCalculationStrategy();
        this.setUserNutrition(calculationStrategy.calculateNutritionalInformation(this));
    }

    public UserInfo() {

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

    public UserNutrition getUserNutrition() {
        return userNutrition;
    }

    public void setUserNutrition(UserNutrition userNutrition) {
        this.userNutrition = userNutrition;
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}

