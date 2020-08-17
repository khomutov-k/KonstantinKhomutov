package hw3.ex1;

import hw3.TestCommons;
import hw3.steps.HomePageSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise1 extends TestCommons {

    private HomePageSteps steps;

    @BeforeMethod
    public void setUp() {
        steps = new HomePageSteps(driver);
    }

    @Test
    public void homePageTest() {
        steps.openHomePage()
                .checkTitle()
                .login()
                .checkUsername()
                .checkTitle()
                .checkHeaderSection()
                .checkIcons()
                .checkTextUnderIcon()
                .checkMainHeader()
                .checkIframe()
                .checkLogoInIframe()
                .switchBackFromIframe()
                .checkSubheader()
                .checkSubheaderLink()
                .checkLeftSection()
                .checkFooter()
                .checkSoftAssertions();
    }
}

