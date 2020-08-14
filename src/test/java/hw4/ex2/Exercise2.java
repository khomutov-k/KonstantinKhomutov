package hw4.ex2;

import hw4.TestCommons;
import hw4.steps.DifferentElementSteps;
import hw4.steps.HomePageSteps;
import hw4.utils.PropertiesHandler;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class Exercise2 extends TestCommons {

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
    public void differentElementPageTest() {
        homeSteps.openHomePage()
                .checkTitle()
                .login()
                .checkUsername()
                .checkTitle()
                .checkHeaderServiceDropdown()
                .checkLeftSectionServiceDropdown()
                .checkSoftAssertions();
        elementSteps.openDifferentElementPageTest()
                .checkInterface()
                .checkRightSection()
                .checkLeftSection()
                .selectCheckboxes("Wind", "Water")
                .checkCheckboxes(true, "Wind", "Water")
                .selectRadio("Selen")
                .checkRadios("Selens")
                .selectDropdown("Yellow")
                .checkDropdown("Yellow")
                .selectCheckboxes("Wind", "Water")
                .checkCheckboxes(false, "Wind", "Water")
                .checkSoftAssertions();

    }
}
