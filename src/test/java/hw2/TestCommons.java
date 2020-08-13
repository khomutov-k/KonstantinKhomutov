package hw2;

import hw2.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestCommons {

    protected WebDriver driver;
    protected String baseUrl = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeMethod
    public void setUp()  {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        DriverSingleton.closeDriver();
    }
}
