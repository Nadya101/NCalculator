package tests;

import calc.Menu;
import java.io.ByteArrayInputStream;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.InputMismatchException;

@Listeners
public class ReadIntTest {
    InputStream defaultInputStream;

    @BeforeMethod
    public void readIntBeforeMethod() {
        defaultInputStream = System.in;
    }

    @AfterMethod(alwaysRun = true)
    public void readIntTestAfterMethod() {
        System.setIn(defaultInputStream);
    }

    @DataProvider
    public Object[][] readIntValidData() {
        return new Object[][]{
                {"12", 12},
                {"-1458545", -1458545},
                {"99999999", 99999999},
                {"54684646", 54684646},
                {"0", 0}
        };
    }

    @Test(dataProvider = "readIntValidData", description = "Read int value from console",
            groups = {"Console test"}, retryAnalyzer = Retry.class)
    public void readDoubleTest(String data, int expectedResult) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
       Menu menu = new Menu();
        int actualResult = menu.readInt();
        Assert.assertEquals(actualResult, expectedResult);
    }
}