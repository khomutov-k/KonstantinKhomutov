package hw3.ex1;

import hw3.TestCommons;
import hw3.model.User;
import hw3.model.UserManager;
import hw3.page.HomePage;
import hw3.page.HomePageFrame;
import hw3.page.LoginForm;
import hw3.utils.Helper;
import hw3.utils.PropertiesHandler;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends TestCommons {

    private HomePage homePage;

    @Test
    public void openHomePageTest() {
        // Step 1. Open test site by URL
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.waitForPageLoad();
    }

    @Test(priority = 2)
    public void titleTest() {
        //Step 2. Verify Title of the Page

        assertEquals(homePage.getTitle(),props.getProperty("expectedTitle"));

    }

    @Test(priority = 1)
    public void loginTest() {

        //Step 3. Perform login
        LoginForm form = homePage.getLoginForm();
        final User defaultUserFromProperties = UserManager.createDefaultUserFromProperties(props);
        form.login(defaultUserFromProperties);

        //Step 4.Assert User name in the left-top side of screen that user is loggined
        String expectedUsername = "ROMAN IOVLEV";
        assertEquals(homePage.getUserName(), expectedUsername);

        //Step 5. Verify Title of the Page
        assertEquals(homePage.getTitle(),props.getProperty("expectedTitle"));
    }

    @Test(priority = 2)
    public void headerSectionAreDisplayedTest() {
        //Step 6. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        Set<String> headerTitles = PropertiesHandler.getPropertySet(props,"headers");
        Helper.compareWebElementsWithSet(homePage.headerItems, headerTitles);
    }

    @Test(priority = 2)
    public void imagesAreDisplayedTest() {
        //Step 7. Assert that there are 4 images on the Index Page and they are displayed
        String expectedNumberOfIcons = props.getProperty("expectedNumberOfIcons");
        String actualNumberOfIcons = String.valueOf(homePage.benefitIcons.size());
        assertEquals(actualNumberOfIcons, expectedNumberOfIcons);
    }

    @Test(priority = 2)
    public void textUnderIconTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        //Step 8. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        Set<String> benefitTextSet = PropertiesHandler.getPropertySet(props,"benefitText");
        Helper.textOfWebElementsContainsSetText(homePage.benefitTexts,
                benefitTextSet,softAssertions);
        softAssertions.assertAll();
    }

    @Test(priority = 2)
    public void mainHeaderTest() {
        //Step 9. Assert a text of the main headers
        String expectedMainTitle = props.getProperty("expectedMainTitle");
        assertEquals(homePage.mainTitle.getText(), expectedMainTitle);

        String expectedMainText = props.getProperty("expectedMainText");
        assertEquals(homePage.mainText.getText(), expectedMainText);
    }

    @Test(priority = 2)
    public void iframeTest() {
        //Step 10. Assert that there is the iframe in the center of Page
        assertTrue(homePage.secondFrame.isDisplayed());

        //Step 11. Switch to the iframe
        // and check that there is Epam logo in the left top conner of iframe
        HomePageFrame frame = homePage.switchToFrame("second_frame");
        assertTrue(frame.logo.isDisplayed());

        //Step 12. Switch to original window back
        frame.switchBack();
    }

    @Test(priority = 2)
    public void subHeaderAndLinkTest() {
        //Step 13. Assert a text of the sub header
        String actualSubHeaderText = homePage.subHeaderLink.getText();
        String expectedSubHeaderText = props.getProperty("expectedSubHeaderText");
        assertEquals(actualSubHeaderText, expectedSubHeaderText);

        //Step 14. Assert that JDI GITHUB is a link and has a proper URL
        String actualLink = homePage.subHeaderLink.getAttribute("href");
        //String expectedLink = "https://jdi-testing.github.io/jdi-light/index.html";
        String expectedLink = props.getProperty("expectedLink");
        assertEquals(actualLink, expectedLink);
    }

    @Test(priority = 2)
    public void leftSectionTest() {
        //Step 15. Assert that there is Left Section
        assertTrue(homePage.navigationSidebar.isDisplayed());
    }

    @Test(priority = 2)
    public void footerTest() {
        //Step 16. Assert that there is Footer
        assertTrue(homePage.footer.isDisplayed());
    }
}

