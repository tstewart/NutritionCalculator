package io.github.tstewart.NutritionCalculator.strategies;

import io.github.tstewart.NutritionCalculator.UserInfo;
import io.github.tstewart.NutritionCalculator.UserNutrition;
import org.junit.Assert;
import org.junit.Test;

public class NutritionCalculationStrategyTest {

    @Test
    public void calculatesMaleNutrition() {
        //arrange
        final UserInfo userInfo = new UserInfo();
        final UserNutrition.UserNutritionCalculation strategy = new NutritionCalculationStrategy();
        userInfo.setAge(20);
        userInfo.setGender(UserInfo.Gender.MALE);
        userInfo.setHeight(150);
        userInfo.setWeight(60);

        //act
        final UserNutrition userNutrition = strategy.calculateNutritionalInformation(userInfo);

        //assert
        // Expected results from the calculation strategy
        Assert.assertEquals(2363, userNutrition.getCaloriesRequired(), 0);
        Assert.assertEquals(330, userNutrition.getCarbohydratesRequired(), 0);
        Assert.assertEquals(52, userNutrition.getFatRequired(), 0);
        Assert.assertEquals(45, userNutrition.getProteinRequired(), 0);
        Assert.assertEquals(35, userNutrition.getFiberRequired(), 0);
    }

    @Test
    public void calculatesFemaleNutrition() {
        //arrange
        final UserInfo userInfo = new UserInfo();
        final UserNutrition.UserNutritionCalculation strategy = new NutritionCalculationStrategy();
        userInfo.setAge(30);
        userInfo.setGender(UserInfo.Gender.FEMALE);
        userInfo.setHeight(180);
        userInfo.setWeight(75);

        //act
        final UserNutrition userNutrition = strategy.calculateNutritionalInformation(userInfo);

        //assert
        // Expected results from the calculation strategy
        Assert.assertEquals(2414, userNutrition.getCaloriesRequired(), 0);
        Assert.assertEquals(413, userNutrition.getCarbohydratesRequired(), 0);
        Assert.assertEquals(53, userNutrition.getFatRequired(), 0);
        Assert.assertEquals(56.25, userNutrition.getProteinRequired(), 0);
        Assert.assertEquals(36, userNutrition.getFiberRequired(), 0);
    }

}