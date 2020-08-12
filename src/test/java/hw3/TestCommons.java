package hw3;

import hw3.driver.DriverSingleton;
import hw3.utils.PropertiesHandler;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

public class TestCommons {

    protected WebDriver driver;
    protected Properties props;

    @BeforeClass
    public void driverLaunch()  {
        driver = DriverSingleton.getDriver();
        props = PropertiesHandler.getProperties();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        DriverSingleton.closeDriver();
    }
}
