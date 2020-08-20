package hw3;

import hw3.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestCommons {

    protected WebDriver driver;

    @BeforeClass
    public void driverLaunch()  {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        DriverSingleton.closeDriver();
    }
}
