package io.github.tstewart.NutritionCalculator;

import io.github.tstewart.NutritionCalculator.strategies.NutritionCalculationStrategy;

import java.io.Serializable;

public class UserInfo implements Serializable {
  private Gender gender;
  private int age;
  private double weight;
  private double height;
  private UserNutrition userNutrition;

  public UserInfo(final Gender gender, final int age, final double weight, final double height)
      throws IllegalArgumentException {
    super();

    if (null == gender) throw new IllegalArgumentException("Please select a gender");
    if (0 > age || 120 < age) throw new IllegalArgumentException("Invalid age (min 0, max 120)");
    if (0 > weight || 500 < weight)
      throw new IllegalArgumentException("Invalid weight (min 0kg, max 500kg)");
    if (0 > height || 250 < height)
      throw new IllegalArgumentException("Invalid height (min 0cm, max 250cm");

    this.gender = gender;
    this.age = age;
    this.weight = weight;
    this.height = height;

    final UserNutrition.UserNutritionCalculation calculationStrategy =
        new NutritionCalculationStrategy();
    setUserNutrition(calculationStrategy.calculateNutritionalInformation(this));
  }

  public UserInfo() {
    super();
  }

  public Gender getGender() {
    return this.gender;
  }

  public void setGender(final Gender gender) {
    this.gender = gender;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(final int age) {
    this.age = age;
  }

  public double getWeight() {
    return this.weight;
  }

  public void setWeight(final double weight) {
    this.weight = weight;
  }

  public double getHeight() {
    return this.height;
  }

  public void setHeight(final double height) {
    this.height = height;
  }

  public UserNutrition getUserNutrition() {
    return this.userNutrition;
  }

  public void setUserNutrition(final UserNutrition userNutrition) {
    this.userNutrition = userNutrition;
  }

  public enum Gender {
    MALE,
    FEMALE
  }
}
