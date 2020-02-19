package io.github.tstewart.NutritionCalculator;

import java.io.Serializable;

public class UserNutrition implements Serializable {
    private int caloriesRequired;
    private double fiberRequired;
    private double fatRequired;
    private double carbohydratesRequired;
    private double proteinRequired;

    public UserNutrition(int caloriesRequired, double fiberRequired, double fatRequired, double carbohydratesRequired, double proteinRequired) {
        this.caloriesRequired = caloriesRequired;
        this.fiberRequired = fiberRequired;
        this.fatRequired = fatRequired;
        this.carbohydratesRequired = carbohydratesRequired;
        this.proteinRequired = proteinRequired;
    }

    public UserNutrition() {

    }

    public int getCaloriesRequired() {
        return caloriesRequired;
    }

    public void setCaloriesRequired(int caloriesRequired) {
        this.caloriesRequired = caloriesRequired;
    }

    public double getFiberRequired() {
        return fiberRequired;
    }

    public void setFiberRequired(double fiberRequired) {
        this.fiberRequired = fiberRequired;
    }

    public double getFatRequired() {
        return fatRequired;
    }

    public void setFatRequired(double fatRequired) {
        this.fatRequired = fatRequired;
    }

    public double getCarbohydratesRequired() {
        return carbohydratesRequired;
    }

    public void setCarbohydratesRequired(double carbohydratesRequired) {
        this.carbohydratesRequired = carbohydratesRequired;
    }

    public double getProteinRequired() {
        return proteinRequired;
    }

    public void setProteinRequired(double proteinRequired) {
        this.proteinRequired = proteinRequired;
    }

    public interface UserNutritionCalculation {
        UserNutrition calculateNutritionalInformation(UserInfo info);
    }
}
