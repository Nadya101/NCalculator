package tests;

import calc.Calculator;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners
public class MultiplicationTest {

    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] multiplicationData() {
        return new Object[][]{
                {0, 3, 0},
                {200, 100, 20000},
                {0.5, 0.3, 0.15},
                {75, 2, 150},
                {532, 32, 17024}
        };
    }

    @Test(dataProvider = "multiplicationData", description = "Multiplication test", groups = {"Math tests"},
            invocationCount = 2, threadPoolSize = 2, priority = 2)
    public void multiplicationTest(double firstNumber, double secondNumber, double expectedResult) {
        Assert.assertEquals(calculator.multiplication(firstNumber, secondNumber), expectedResult, 0);
    }
}