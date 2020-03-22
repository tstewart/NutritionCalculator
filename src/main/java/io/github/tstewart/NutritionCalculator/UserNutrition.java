package io.github.tstewart.NutritionCalculator;

import java.io.Serializable;

/**
 * Author: Thomas Stewart
 */
public class UserNutrition implements Serializable {
  private int caloriesRequired;
  private double fiberRequired;
  private double fatRequired;
  private double carbohydratesRequired;
  private double proteinRequired;

  public UserNutrition(
      final int caloriesRequired,
      final double fiberRequired,
      final double fatRequired,
      final double carbohydratesRequired,
      final double proteinRequired) {
    super();
    this.caloriesRequired = caloriesRequired;
    this.fiberRequired = fiberRequired;
    this.fatRequired = fatRequired;
    this.carbohydratesRequired = carbohydratesRequired;
    this.proteinRequired = proteinRequired;
  }

  public UserNutrition() {
    super();
  }

  public int getCaloriesRequired() {
    return this.caloriesRequired;
  }

  public void setCaloriesRequired(final int caloriesRequired) {
    this.caloriesRequired = caloriesRequired;
  }

  public double getFiberRequired() {
    return this.fiberRequired;
  }

  public void setFiberRequired(final double fiberRequired) {
    this.fiberRequired = fiberRequired;
  }

  public double getFatRequired() {
    return this.fatRequired;
  }

  public void setFatRequired(final double fatRequired) {
    this.fatRequired = fatRequired;
  }

  public double getCarbohydratesRequired() {
    return this.carbohydratesRequired;
  }

  public void setCarbohydratesRequired(final double carbohydratesRequired) {
    this.carbohydratesRequired = carbohydratesRequired;
  }

  public double getProteinRequired() {
    return this.proteinRequired;
  }

  public void setProteinRequired(final double proteinRequired) {
    this.proteinRequired = proteinRequired;
  }

    /**
     * Calculation strategy interface
     */
  public interface UserNutritionCalculation {
    UserNutrition calculateNutritionalInformation(UserInfo info);
  }
}
