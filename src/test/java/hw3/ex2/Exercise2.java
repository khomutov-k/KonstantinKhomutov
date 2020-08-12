package hw3.ex2;

import hw3.TestCommons;
import hw3.model.UserManager;
import hw3.page.DifferentElementPage;
import hw3.page.HomePage;
import hw3.page.LoginForm;
import hw3.utils.Helper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise2 extends TestCommons {

    HomePage homePage;
    DifferentElementPage elementPage;
    SoftAssertions softAssert;

    @BeforeMethod
    public void setUps() {
        softAssert = new SoftAssertions();
    }

    @Test
    public void openHomePageTest() {
        // Step 1. Open test site by URL
        homePage = new HomePage(driver);
        homePage.openPage();

        //Step 2. Verify Title of the Page
        String actualTitle = homePage.getTitle();
        String expectedTitle = "Home Page";
        softAssert.assertThat(actualTitle).as("Title is wrong")
                .isEqualTo(expectedTitle);
    }

    @Test(priority = 1)
    public void loginTest() {
        //Step 3. Perform login
        LoginForm form = homePage.getLoginForm();
        form.login(UserManager.createDefaultUserFromProperties(props));

        //Step 4.Assert User name in the left-top side of screen that user is loggined
        String actualUsername = homePage.getUserName();
        String expectedUsername = "ROMAN IOVLEV";
        softAssert.assertThat(actualUsername).as("Wrong user")
                .isEqualTo(expectedUsername);
    }

    @Test(priority = 1)
    public void serviceHeaderTest() {
        //Step 5. Click on "Service" subcategory in the header
        //and check that drop down contains options
        driver.findElement(By.cssSelector("li[index=\"3\"] a")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.sub")));
        List<WebElement> serviceLinks = driver.findElements(By.cssSelector(
                "li[index=\"3\"] > ul li"));
        Set<String> expectedLinks = new HashSet<>(Arrays.asList(
                "Support", "Search", "Dates", "Complex Table", "Simple Table",
                "Table with pages", "Different elements", "Performance", "User Table"));
        Helper.compareWebElementsWithSet(serviceLinks, expectedLinks, softAssert);

        //Step 6. Click on Service subcategory in the left section and check that drop down
        //contains options
        driver.findElement(By.cssSelector("ul.nav li.dropdown")).click();
        List<WebElement> serviceDropdownLinks = driver.findElements(By.cssSelector(
                "ul.nav li.dropdown li"));
        Set<String> expectedDropdownLinks = expectedLinks.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        Helper.compareWebElementsWithSet(serviceDropdownLinks, expectedDropdownLinks, softAssert);
    }

    @Test(priority = 2)
    public void openDifferentElementPageTest() {
        //Step 7. Open through the header menu Service -> Different Elements Page
        homePage.differentElementLink.click();
        elementPage = homePage.getElementPage();
    }

    @Test(priority = 3)
    public void interfaceTest() {
        //Step 8. Check interface on Different elements Page, it contains all needed elements
        softAssert.assertThat(elementPage.checkBoxes.size()).as("Number of checkbox is not 4")
                .isEqualTo(4);
        softAssert.assertThat(elementPage.radios.size()).as("Number of radio is not 4")
                .isEqualTo(4);
        softAssert.assertThat(elementPage.dropdown.isDisplayed()).as("No dropdown menu")
                .isTrue();
        softAssert.assertThat(elementPage.buttons.size()).as("Button number is not 2")
                .isEqualTo(2);
    }

    @Test(priority = 3)
    public void rightSectionTest() {
        //Step 9. Assert that there is Right Section
        boolean logSidebarIsDisplayed = elementPage.logSidebar.isDisplayed();
        softAssert.assertThat(logSidebarIsDisplayed).as("Right section is not found");
    }

    @Test(priority = 3)
    public void leftSection() {
        //Step 10. Assert that there is Left Section
        boolean sidebarIsDisplayed = elementPage.navigationSidebar.isDisplayed();
        softAssert.assertThat(sidebarIsDisplayed).as("Left section is not found").isTrue();
    }

    @Test(priority = 3)
    public void checkboxesWindAndWaterTest() {
        //Step 11. Select checkboxes
        elementPage.findInputOfCheckboxByLabel("Wind").click();
        elementPage.findInputOfCheckboxByLabel("Water").click();

        //Step 12. Assert that for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox.

        Set<String> expectedLogMessages = new HashSet<>(Arrays.asList(
                "Water: condition changed to true",
                "Wind: condition changed to true"
        ));
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
    }

    @Test(priority = 3)
    public void radioSelenTest() {
        //Step 13. Select radio
        elementPage.findInputOfRadioByLabel("Selen").click();

        //Step 14. Assert that for radiobutton there is a log row
        //and value is corresponded to the status of radiobutton.
        Set<String> expectedLogMessages = new HashSet<>();
        expectedLogMessages.add("metal: value changed to Selen");
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);

    }

    @Test(priority = 3)
    public void dropdownTest() {
        //Step 15. Select in dropdown
        elementPage.getOptionByName("Yellow").click();

        //Step 16. Assert that for dropdown there is a log row
        //and value is corresponded to the selected value.
        Set<String> expectedLogMessages = new HashSet<>();
        expectedLogMessages.add("Colors: value changed to Yellow");
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
    }

    @Test(priority = 4)
    public void checkboxUncheckTest() {

        elementPage.findInputOfCheckboxByLabel("Water").click();
        elementPage.findInputOfCheckboxByLabel("Wind").click();

        //Step 18. Assert that for each checkbox there is an individual log row
        //and value is corresponded to the status of checkbox.
        Set<String> expectedLogMessages = new HashSet<>(Arrays.asList(
                "Water: condition changed to false",
                "Wind: condition changed to false"
        ));
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
        softAssert.assertAll();
    }
}
