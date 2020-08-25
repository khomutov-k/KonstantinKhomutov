package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestCommons {

    WebDriver driver;

    @BeforeClass
    public void driverLaunch(ITestContext context)  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
