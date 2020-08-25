package hw4.ex1;

import hw4.TestCommons;
import hw4.steps.HomePageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise1 extends TestCommons {

    private HomePageSteps steps;

    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        steps = new HomePageSteps(driver);
    }

    @Feature(value = "JDI site test")
    @Story(value = "Home Page test")
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

