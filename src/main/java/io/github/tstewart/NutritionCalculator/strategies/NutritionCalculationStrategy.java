package io.github.tstewart.NutritionCalculator.strategies;

import io.github.tstewart.NutritionCalculator.UserInfo;
import io.github.tstewart.NutritionCalculator.UserNutrition;

public class NutritionCalculationStrategy implements UserNutrition.UserNutritionCalculation {

    /**
     * Calculates nutritional information (calories, nutrients required) with the provided user information
     * Calories are calculated with the following formula:
     *
     * Adult male: 66 + (6.3 x body weight in lbs.) + (12.9 x height in inches) - (6.8 x age in years)
     * Adult female: 655 + (4.3 x weight in lbs.) + (4.7 x height in inches) - (4.7 x age in years)
     *
     * These values are then multiplied by 1.55, assuming a normal amount of exercise by the user.
     *
     * @param info User information (age, gender, etc.)
     * @return Nutrition required for this user
     */
    @Override
    public UserNutrition calculateNutritionalInformation(UserInfo info) {
        UserNutrition nutrition = new UserNutrition();
        double caloriesRequired = getCaloriesRequired(info);

        nutrition.setCaloriesRequired((int) Math.floor(caloriesRequired));
        return nutrition;
    }

    private double getCaloriesRequired(UserInfo info) {
        double calorieCalculation;

        if(info.getGender() == UserInfo.Gender.MALE) {
            calorieCalculation = (66 + (convertKgToLb(info.getWeight()) * 6.3) + (convertCmToIn(info.getHeight()) * 12.9) - (info.getAge() * 6.8));
        }
        else {
            calorieCalculation = (655 + (convertKgToLb(info.getWeight()) * 4.3) + (convertCmToIn(info.getHeight()) * 4.7) - (info.getAge() * 4.7));
        }
        return calorieCalculation * 1.55;
    }

    private double convertKgToLb(double weightKg) {
        return weightKg * ImperialConversion.KgToLb.conversionRate;
    }

    private double convertCmToIn(double heightCm) {
        return heightCm * ImperialConversion.cmToIn.conversionRate;
    }
}

enum ImperialConversion {
    KgToLb(2.20462),
    cmToIn(0.393701);

    double conversionRate;

    ImperialConversion(double conversionRate) {
        this.conversionRate = conversionRate;
    }

}
