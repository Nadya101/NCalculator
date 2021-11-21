package tests;

import calc.Calculator;

import org.junit.Assert;
import org.testng.annotations.*;

@Listeners
public class AddTest {

    Calculator calculator= new Calculator();

    @BeforeMethod
    public void textBeforeMethod(){
        System.out.println("Method start");
    }
    @AfterMethod
    public void textAfterMethod(){
        System.out.println("Method finish");
    }

    @BeforeTest
    public void textBeforeTest(){
        System.out.println("Test start");
    }

    @DataProvider(parallel = true)
    public Object[][] addData() {
        return new Object[][]{
                {0, 3, 3},
                {0.5, 0.3, 0.8},
                {75, 2, 77},
                {32, 32, 64}
        };
    }

    @Test(dataProvider = "addData", description = "Add test", groups = {"Math tests"}, priority = 1,
            invocationCount=2, threadPoolSize = 2)
    public void addTest(double firstNumber, double secondNumber, double expectedResult) {
        Assert.assertEquals(calculator.add(firstNumber, secondNumber), expectedResult, 0);
    }
}