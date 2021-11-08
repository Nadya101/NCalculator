package tests;

import calc.Calculator;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class DivisionTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] divisionData() {
        return new Object[][]{
                {0, 3, 0},
                {3, 0, -1},
                {0.4, 0.2, 2},
                {75, 2, 37.5},
                {532, 0.7, 760}
        };
    }

    @Test(dataProvider = "divisionData", description = "Division test",priority = 2, groups = {"Math tests"},
            invocationCount=2, threadPoolSize = 2)
    public void divisionTest(double firstNumber, double secondNumber, double expectedResult) {
        Assert.assertEquals(calculator.division(firstNumber, secondNumber), expectedResult, 0);
    }
}