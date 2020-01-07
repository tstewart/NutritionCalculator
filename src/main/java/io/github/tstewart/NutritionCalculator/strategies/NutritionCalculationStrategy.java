package io.github.tstewart.NutritionCalculator.strategies;

import io.github.tstewart.NutritionCalculator.UserInfo;
import io.github.tstewart.NutritionCalculator.UserNutrition;

public class NutritionCalculationStrategy implements UserNutrition.UserNutritionCalculation {

    /**
     * Calculates nutritional information (calories, nutrients required) with the provided user information
     * @param info User information (age, gender, etc.)
     * @return Nutrition required for this user
     */
    @Override
    public UserNutrition calculateNutritionalInformation(UserInfo info) {
        return null;
    }

}
