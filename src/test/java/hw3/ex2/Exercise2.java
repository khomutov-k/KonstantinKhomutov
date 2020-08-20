package hw3.ex2;

import hw3.TestCommons;
import hw3.steps.DifferentElementSteps;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise2 extends TestCommons {

    private HomePageSteps homeSteps;
    private DifferentElementSteps elementSteps;

    @BeforeMethod
    public void setUp() {
        homeSteps = new HomePageSteps(driver);
        elementSteps = new DifferentElementSteps(driver);
    }

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
                .checkRadios("Selen")
                .selectDropdown("Yellow")
                .checkDropdown("Yellow")
                .selectCheckboxes("Wind", "Water")
                .checkCheckboxes(false, "Wind", "Water")
                .checkSoftAssertions();

    }
}
