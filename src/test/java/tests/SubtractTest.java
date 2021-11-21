package tests;

import calc.Calculator;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] subtractData() {
        return new Object[][]{
                {0, 3, -3},
                {200, 100, 100},
                {0.5, 0.3, 0.2},
                {75, 2, 73},
                {32, 32, 0}
        };
    }

    @Test(dataProvider = "subtractData", priority = 1, groups = {"Math tests"}, invocationCount=2, threadPoolSize = 2)
    public void subtractTest(double firstNumber, double secondNumber, double expectedResult) {
        Assert.assertEquals(calculator.subtract(firstNumber, secondNumber), expectedResult, 0);
    }
}