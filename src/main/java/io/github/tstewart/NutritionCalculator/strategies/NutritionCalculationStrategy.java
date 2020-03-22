package io.github.tstewart.NutritionCalculator.strategies;

import io.github.tstewart.NutritionCalculator.UserInfo;
import io.github.tstewart.NutritionCalculator.UserNutrition;

/**
 * Author: Thomas Stewart
 */
public class NutritionCalculationStrategy implements UserNutrition.UserNutritionCalculation {

  /**
   * Calculates nutritional information (calories, nutrients required) with the provided user
   * information Calories are calculated with the following formula:
   *
   * <p>Adult male: 66 + (6.3 x body weight in lbs.) + (12.9 x height in inches) - (6.8 x age in
   * years) Adult female: 655 + (4.3 x weight in lbs.) + (4.7 x height in inches) - (4.7 x age in
   * years)
   *
   * <p>These values are then multiplied by 1.55, assuming a normal amount of exercise by the user.
   *
   * @param info User information (age, gender, etc.)
   * @return Nutrition required for this user
   */
  @Override
  public UserNutrition calculateNutritionalInformation(final UserInfo info) {
    final UserNutrition nutrition = new UserNutrition();
    final double caloriesRequired = this.getCaloriesRequired(info);

    nutrition.setCaloriesRequired((int) Math.floor(caloriesRequired));
    // Carbohydrates calculated equal to 250% weight in lbs
    nutrition.setCarbohydratesRequired((int) Math.floor(convertKgToLb(info.getWeight()) * 2.5));
    // Fat calculated equal to 20% of calorie requirement, divided by 9
    nutrition.setFatRequired((int) Math.floor((caloriesRequired * 0.2) / 9));
    // Protein calculated equal to 75% of weight
    nutrition.setProteinRequired(info.getWeight() * 0.75);
    // Fibre calculated equal to 15 * 1/1000th of calorie requirements
    nutrition.setFiberRequired((int) Math.floor(15 * (caloriesRequired / 1000)));
    return nutrition;
  }

    /**
     * Calculates calorie requirements based on the biological gender of the user
     * @param info User information (age, weight, gender, height)
     * @return Calorie requirements for the user.
     */
  private double getCaloriesRequired(final UserInfo info) {
    final double calorieCalculation;

    calorieCalculation =
        UserInfo.Gender.MALE == info.getGender()
            // If gender is male
            ? 66
                // Weight in lb * 6.3
                + (this.convertKgToLb(info.getWeight()) * 6.3)
                // Height in inches * 12.9
                + (this.convertCmToIn(info.getHeight()) * 12.9)
                // Age * 6.8
                - (info.getAge() * 6.8)
            // If gender is female
            : 655
                // Weight in lb * 4.3
                + (this.convertKgToLb(info.getWeight()) * 4.3)
                // Height in inches * 4.7
                + (this.convertCmToIn(info.getHeight()) * 4.7)
                // Age * 4.7
                - (info.getAge() * 4.7);
    // Returns calorie requirements * 1.55, assuming moderate exercise on behalf of the user.
    return calorieCalculation * 1.55;
  }

    /**
     * Converts from kilograms to pounds
     * @param weightKg Weight in kilograms
     * @return Weight in pounds
     */
  private double convertKgToLb(final double weightKg) {
    return weightKg * ImperialConversion.KgToLb.conversionRate;
  }

    /**
     * Converts from centimeters to inches
     * @param heightCm Height in centimeters
     * @return Height in inches
     */
  private double convertCmToIn(final double heightCm) {
    return heightCm * ImperialConversion.cmToIn.conversionRate;
  }
}

/**
 * Conversion rates for metric to imperial
 */
enum ImperialConversion {
  KgToLb(2.20462),
  cmToIn(0.393701);

  final double conversionRate;

  ImperialConversion(final double conversionRate) {
    this.conversionRate = conversionRate;
  }
}
