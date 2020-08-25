package hw3.steps;

import hw3.model.User;
import hw3.model.UserManager;
import hw3.page.HomePage;
import hw3.page.HomePageFrame;
import hw3.page.LoginForm;
import hw3.utils.Helper;
import hw3.utils.PropertiesHandler;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSteps {

    private HomePage homePage;
    private HomePageFrame frame;
    private Properties props = PropertiesHandler.getProperties();
    private WebDriver driver;
    private SoftAssertions softAssertions;

    public HomePageSteps(WebDriver driver) {
        softAssertions = new SoftAssertions();
        homePage = new HomePage(driver);
        this.driver = driver;
    }

    
    //(value = "Open test site by URL")
    public HomePageSteps openHomePage() {
        homePage.openPage();
        homePage.waitForPageLoad();
        return this;
    }

    
    //(value = "Verify Title of the Page")
    public HomePageSteps checkTitle() {
        assertEquals(homePage.getTitle(), props.getProperty("expectedTitle"));
        return this;

    }

    
    //(value = "Perform login")
    public HomePageSteps login() {
        LoginForm form = homePage.getLoginForm();
        final User defaultUserFromProperties = UserManager.createDefaultUserFromProperties(props);
        form.login(defaultUserFromProperties);
        return this;
    }

    
    //(value = "Assert User name in the left-top side of screen that user is loggined")
    public HomePageSteps checkUsername() {
        String expectedUsername = props.getProperty("expectedUsername");
        assertEquals(homePage.getUserName(), expectedUsername);
        return this;
    }

    
    //(value = "Assert that there are 4 items on the header section are displayed"
    //        + "and they have proper texts")
    public HomePageSteps checkHeaderSection() {
        Set<String> headerTitles = PropertiesHandler.getPropertySet(props, "headers");
        Helper.compareWebElementsWithSet(homePage.headerItems, headerTitles);
        return this;
    }

    
    //(value = "Assert that there are 4 images on the Index Page and they are displayed")
    public HomePageSteps checkIcons() {
        String expectedNumberOfIcons = props.getProperty("expectedNumberOfIcons");
        String actualNumberOfIcons = String.valueOf(homePage.benefitIcons.size());
        assertEquals(actualNumberOfIcons, expectedNumberOfIcons);
        return this;
    }

    
    //(value = "Assert that there are 4 texts on the Index Page under icons"
    //       + "and they have proper text")
    public HomePageSteps checkTextUnderIcon() {
        SoftAssertions softAssertions = new SoftAssertions();
        Set<String> benefitTextSet = PropertiesHandler.getPropertySet(props, "benefitText");
        Helper.textOfWebElementsContainsSetText(homePage.benefitTexts,
                benefitTextSet, softAssertions);
        softAssertions.assertAll();
        return this;
    }

    
    //(value = "Assert a text of the main headers")
    public HomePageSteps checkMainHeader() {
        String expectedMainTitle = props.getProperty("expectedMainTitle");
        assertEquals(homePage.mainTitle.getText(), expectedMainTitle);

        String expectedMainText = props.getProperty("expectedMainText");
        assertEquals(homePage.mainText.getText(), expectedMainText);
        return this;
    }

    
    //(value = "Assert that there is the iframe in the center of Page")
    public HomePageSteps checkIframe() {
        assertTrue(homePage.secondFrame.isDisplayed());
        return this;
    }

    
    //(value = "Switch to the iframe"
    //        + "and check that there is Epam logo in the left top conner of iframe")
    public HomePageSteps checkLogoInIframe() {
        frame = homePage.switchToFrame("second_frame");
        assertTrue(frame.logo.isDisplayed());
        return this;
    }

    
    //(value = "Switch to original window back")
    public HomePageSteps switchBackFromIframe() {
        frame.switchBack();
        return this;
    }

    
    //(value = "Assert a text of the sub header")
    public HomePageSteps checkSubheader() {
        String actualSubHeaderText = homePage.subHeaderLink.getText();
        String expectedSubHeaderText = props.getProperty("expectedSubHeaderText");
        assertEquals(actualSubHeaderText, expectedSubHeaderText);
        return this;
    }

    
    //(value = "Assert that JDI GITHUB is a link and has a proper URL")
    public HomePageSteps checkSubheaderLink() {
        String actualLink = homePage.subHeaderLink.getAttribute("href");
        //String expectedLink = "https://jdi-testing.github.io/jdi-light/index.html";
        String expectedLink = props.getProperty("expectedLink");
        assertEquals(actualLink, expectedLink);
        return this;
    }

    
    //(value = "Assert that there is Left Section")
    public HomePageSteps checkLeftSection() {
        assertTrue(homePage.navigationSidebar.isDisplayed());
        return this;
    }

    
    //(value = "Assert that there is Footer")
    public HomePageSteps checkFooter() {
        assertTrue(homePage.footer.isDisplayed());
        return this;
    }

    
    //(value = "Click on Service subcategory in the header"
    //        + "and check that drop down contains options")
    public HomePageSteps checkHeaderServiceDropdown() {
        List<WebElement> serviceLinks = homePage.getHeaderServiceLinks();
        Set<String> expectedLinks = PropertiesHandler.getPropertySet(props,"headerServiceLink");
        Helper.compareWebElementsWithSet(serviceLinks, expectedLinks, softAssertions);
        return this;
    }
    
    
    //(value = "Click on Service subcategory in the left section and check that drop down"
    //+ "contains options")
    public HomePageSteps checkLeftSectionServiceDropdown() {
        Set<String> expectedLinks = PropertiesHandler.getPropertySet(props,"headerServiceLink");
        List<WebElement> serviceDropdownLinks = homePage.getLeftSectionServiceLinks();
        Set<String> expectedDropdownLinks = expectedLinks.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        Helper.compareWebElementsWithSet(serviceDropdownLinks,
                expectedDropdownLinks, softAssertions);
        return this;
    }

    
    public HomePageSteps checkSoftAssertions() {
        softAssertions.assertAll();
        return this;
    }
}
