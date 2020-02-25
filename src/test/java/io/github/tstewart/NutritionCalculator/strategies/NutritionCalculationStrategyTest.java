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
        Assert.assertEquals(1830, userNutrition.getCaloriesRequired(), 0);
        Assert.assertEquals(330, userNutrition.getCarbohydratesRequired(), 0);
        Assert.assertEquals(40, userNutrition.getFatRequired(), 0);
        Assert.assertEquals(112, userNutrition.getProteinRequired(), 0);
        Assert.assertEquals(27, userNutrition.getFiberRequired(), 0);
    }

}