package hw4.ex1;

import hw4.TestCommons;
import hw4.steps.DifferentElementSteps;
import hw4.steps.HomePageSteps;
import hw4.utils.PropertiesHandler;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class FailedTest extends TestCommons {

    private HomePageSteps homeSteps;
    private DifferentElementSteps elementSteps;
    Properties props = PropertiesHandler.getProperties();

    @BeforeMethod
    public void setUp() {
        homeSteps = new HomePageSteps(driver);
        elementSteps = new DifferentElementSteps(driver);
    }

    @Feature(value = "JDI site test")
    @Story(value = "Different Element Page test")
    @Test
    public void shouldFailTest() {
        homeSteps.openHomePage();
        Assert.fail();
    }
}
