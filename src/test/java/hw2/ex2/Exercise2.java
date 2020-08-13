package hw2.ex2;

import hw2.TestCommons;
import hw2.page.LoginForm;
import hw2.utils.Helper;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise2 extends TestCommons {

    @Test
    public void exercise2TestCase() {

        SoftAssertions softAssert = new SoftAssertions();

        // Step 1. Open test site by URL
        driver.get(baseUrl);

        //Step 2. Verify Title of the hw2.page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";
        softAssert.assertThat(actualTitle).as("Title is wrong")
                .isEqualTo(expectedTitle);

        //Step 3. Perform login
        LoginForm form = new LoginForm(driver);
        form.login("Roman", "Jdi1234");

        //Step 4.Assert User name in the left-top side of screen that user is loggined
        String actualUsername = driver.findElement(By.cssSelector("span#user-name")).getText();
        String expectedUsername = "ROMAN IOVLEV";
        softAssert.assertThat(actualUsername).as("Wrong user")
                .isEqualTo(expectedUsername);
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

        //Step 7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.cssSelector("ul.nav li.dropdown li:nth-child(8)")).click();

        //Step 8. Check interface on Different elements hw2.page, it contains all needed elements
        List<WebElement> checkBoxes = driver.findElements(
                By.cssSelector("input[type=\"checkbox\"]"));
        softAssert.assertThat(checkBoxes.size()).as("Number of checkbox is not 4")
                .isEqualTo(4);
        List<WebElement> radios = driver.findElements(By.cssSelector("input[type=\"radio\"]"));
        softAssert.assertThat(radios.size()).as("Number of radio is not 4")
                .isEqualTo(4);
        List<WebElement> dropdown = driver.findElements(By.tagName("select"));
        softAssert.assertThat(dropdown.isEmpty()).as("No dropdown menu")
                .isFalse();
        List<WebElement> buttons = driver.findElements(By.cssSelector(".main-content .uui-button"));
        softAssert.assertThat(buttons.size()).as("Button number is not 2")
                .isEqualTo(2);

        //Step 9. Assert that there is Right Section
        boolean logSidebarIsDisplayed = driver.findElement(By.name("log-sidebar")).isDisplayed();
        softAssert.assertThat(logSidebarIsDisplayed).as("Right section is not found");

        //Step 10. Assert that there is Left Section
        boolean sidebarIsDisplayed = driver.findElement(By.name("navigation-sidebar"))
                .isDisplayed();
        softAssert.assertThat(sidebarIsDisplayed).as("Left section is not found").isTrue();

        //Step 11. Select checkboxes
        List<WebElement> checkBoxesLabels = driver.findElements(
                By.className("label-checkbox"));
        for (WebElement label : checkBoxesLabels) {
            if (label.getText().equals("Water") || label.getText().equals("Wind")) {
                label.findElement(By.tagName("input")).click();
            }
        }

        //Step 12. Assert that for each checkbox there is an individual log row and value
        // is corresponded to the status of checkbox.
        List<WebElement> logLines = driver.findElements(By.cssSelector(".logs li"));
        softAssert.assertThat(logLines.isEmpty()).as("Logs were not found.")
                .isFalse();
        Set<String> expectedLogMessages = new HashSet<>(Arrays.asList(
                "Water: condition changed to true",
                "Wind: condition changed to true"
        ));
        Helper.textOfWebElementsContainsSetText(logLines, expectedLogMessages, softAssert);

        //Step 13. Select radio
        List<WebElement> radioLabels = driver.findElements(
                By.className("label-radio"));
        for (WebElement label : radioLabels) {
            if (label.getText().equals("Selen")) {
                label.findElement(By.tagName("input")).click();
            }
        }

        //Step 14. Assert that for radiobutton there is a log row
        //and value is corresponded to the status of radiobutton.
        logLines = driver.findElements(By.cssSelector(".logs li"));
        expectedLogMessages.clear();
        expectedLogMessages.add("metal: value changed to Selen");
        Helper.textOfWebElementsContainsSetText(logLines, expectedLogMessages, softAssert);

        //Step 15. Select in dropdown
        WebElement dropdownMenu = driver.findElement(By.tagName("select"));
        dropdownMenu.findElement(By.cssSelector("option:nth-child(4)")).click();

        //Step 16. Assert that for dropdown there is a log row
        //and value is corresponded to the selected value.
        logLines = driver.findElements(By.cssSelector(".logs li"));
        expectedLogMessages.clear();
        expectedLogMessages.add("Colors: value changed to Yellow");
        Helper.textOfWebElementsContainsSetText(logLines, expectedLogMessages, softAssert);

        //Step 17. Unselect and assert checkboxes
        for (WebElement label : checkBoxesLabels) {
            if (label.getText().equals("Water") || label.getText().equals("Wind")) {
                label.findElement(By.tagName("input")).click();
            }
        }

        //Step 18. Assert that for each checkbox there is an individual log row
        //and value is corresponded to the status of checkbox.
        logLines = driver.findElements(By.cssSelector(".logs li"));
        expectedLogMessages.clear();
        expectedLogMessages.addAll(Arrays.asList(
                "Water: condition changed to false",
                "Wind: condition changed to false"
        ));
        Helper.textOfWebElementsContainsSetText(logLines, expectedLogMessages, softAssert);
        softAssert.assertAll();
    }
}
