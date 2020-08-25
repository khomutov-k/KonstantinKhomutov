package hw4.ex1;

import hw4.TestCommons;
import hw4.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FailedTest extends TestCommons {

    private HomePageSteps homeSteps;

    @BeforeMethod
    public void setUp(ITestContext context) {
        homeSteps = new HomePageSteps(
                (WebDriver) context.getAttribute("driver"));
    }

    @Feature(value = "JDI site test")
    @Story(value = "Different Element Page test")
    @Test
    public void shouldFailTest() {
        homeSteps.openHomePage();
        Assert.fail();
    }
}
