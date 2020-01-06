package io.github.tstewart.NutritionCalculator;

public class UserNutrition {
    int caloriesRequired;
    double energyRequired;
    double fatRequired;
    double carbohydratesRequired;
    double proteinRequired;

    public UserNutrition(int caloriesRequired, double energyRequired, double fatRequired, double carbohydratesRequired, double proteinRequired) {
        this.caloriesRequired = caloriesRequired;
        this.energyRequired = energyRequired;
        this.fatRequired = fatRequired;
        this.carbohydratesRequired = carbohydratesRequired;
        this.proteinRequired = proteinRequired;
    }

    public int getCaloriesRequired() {
        return caloriesRequired;
    }

    public void setCaloriesRequired(int caloriesRequired) {
        this.caloriesRequired = caloriesRequired;
    }

    public double getEnergyRequired() {
        return energyRequired;
    }

    public void setEnergyRequired(double energyRequired) {
        this.energyRequired = energyRequired;
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
