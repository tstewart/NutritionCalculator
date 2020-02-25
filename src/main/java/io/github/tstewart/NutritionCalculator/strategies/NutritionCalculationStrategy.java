package io.github.tstewart.NutritionCalculator.strategies;

import io.github.tstewart.NutritionCalculator.UserInfo;
import io.github.tstewart.NutritionCalculator.UserNutrition;

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
    nutrition.setCarbohydratesRequired((int) Math.floor(convertKgToLb(info.getWeight()) * 2.5));
    nutrition.setFatRequired((int) Math.floor((caloriesRequired * 0.2) / 9));
    nutrition.setProteinRequired(info.getWeight() * 0.75);
    nutrition.setFiberRequired((int) Math.floor(15 * (caloriesRequired / 1000)));
    return nutrition;
  }

  private double getCaloriesRequired(final UserInfo info) {
    final double calorieCalculation;

    calorieCalculation =
        UserInfo.Gender.MALE == info.getGender()
            ? 66
                + (this.convertKgToLb(info.getWeight()) * 6.3)
                + (this.convertCmToIn(info.getHeight()) * 12.9)
                - (info.getAge() * 6.8)
            : 655
                + (this.convertKgToLb(info.getWeight()) * 4.3)
                + (this.convertCmToIn(info.getHeight()) * 4.7)
                - (info.getAge() * 4.7);
    return calorieCalculation * 1.55;
  }

  private double convertKgToLb(final double weightKg) {
    return weightKg * ImperialConversion.KgToLb.conversionRate;
  }

  private double convertCmToIn(final double heightCm) {
    return heightCm * ImperialConversion.cmToIn.conversionRate;
  }
}

enum ImperialConversion {
  KgToLb(2.20462),
  cmToIn(0.393701);

  final double conversionRate;

  ImperialConversion(final double conversionRate) {
    this.conversionRate = conversionRate;
  }
}
