package tests;

import calc.Menu;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

@Listeners
public class ReadDoubleTest {
    InputStream defaultInputStream;

    @BeforeMethod
    public void readDoubleBeforeMethod() {
        defaultInputStream = System.in;
    }

    @AfterMethod(alwaysRun = true)
    public void readDoubleTestAfterMethod() {
        System.setIn(defaultInputStream);
    }

    @DataProvider
    public Object[][] readDoubleValidData() {
        return new Object[][]{
                {"12", 12.0},
                {"-1458545", -1458545.0},
                {"99999999", 99999999.0},
                {"0", 0}
        };
    }

    @Test(dataProvider = "readDoubleValidData", description = "Read double value from console",
            groups = {"Console test"}, retryAnalyzer = Retry.class)
    public void readDoubleTest(String data, double expectedResult) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu menu = new Menu();
        double actualResult = menu.readInt();
        Assert.assertEquals(actualResult, expectedResult);
    }
}