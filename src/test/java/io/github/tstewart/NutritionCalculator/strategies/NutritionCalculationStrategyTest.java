package io.github.tstewart.NutritionCalculator.strategies;

import io.github.tstewart.NutritionCalculator.UserInfo;
import io.github.tstewart.NutritionCalculator.UserNutrition;
import org.junit.Test;

import static org.junit.Assert.*;

public class NutritionCalculationStrategyTest {

    @Test
    public void calculatesMaleNutrition() {
        //arrange
        UserInfo userInfo = new UserInfo();
        NutritionCalculationStrategy strategy = new NutritionCalculationStrategy();
        userInfo.setAge(20);
        userInfo.setGender(UserInfo.Gender.MALE);
        userInfo.setHeight(150);
        userInfo.setWeight(60);

        //act
        UserNutrition userNutrition = strategy.calculateNutritionalInformation(userInfo);

        //assert
        assertEquals(1830, userNutrition.getCaloriesRequired());

    }

}