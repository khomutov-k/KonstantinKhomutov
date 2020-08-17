package hw5.steps;

import hw5.page.DifferentElementPage;
import hw5.page.HomePage;
import hw5.utils.Helper;
import hw5.utils.PropertiesHandler;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class DifferentElementSteps {

    HomePage homePage;
    DifferentElementPage elementPage;
    SoftAssertions softAssert;
    Properties props;
    WebDriver driver;


    public DifferentElementSteps(WebDriver driver) {
        softAssert = new SoftAssertions();
        homePage = new HomePage(driver);
        elementPage = homePage.getDifferentElementPage();
        props = PropertiesHandler.getProperties();
        this.driver = driver;
    }

    @Step
    @Description(value = "Open through the header menu Service -> Different Elements Page")
    public DifferentElementSteps openDifferentElementPageTest() {
        homePage.differentElementLink.click();
        return this;
    }

    @Step
    @Description(value = "Check interface on Different elements Page, "
            + "it contains all needed elements")
    public DifferentElementSteps checkInterface() {
        //Step 8.
        softAssert.assertThat(elementPage.checkBoxes.size())
                .as("Number of checkbox is not 4")
                .isEqualTo(4);
        softAssert.assertThat(elementPage.radios.size()).as("Number of radio is not 4")
                .isEqualTo(4);
        softAssert.assertThat(elementPage.dropdown.isDisplayed()).as("No dropdown menu")
                .isTrue();
        softAssert.assertThat(elementPage.buttons.size()).as("Button number is not 2")
                .isEqualTo(2);
        return this;
    }

    @Step
    @Description(value = "Assert that there is Right Section")
    public DifferentElementSteps checkRightSection() {
        //Step 9.
        boolean logSidebarIsDisplayed = elementPage.logSidebar.isDisplayed();
        softAssert.assertThat(logSidebarIsDisplayed).as("Right section is not found");
        return this;
    }

    @Step
    @Description(value = "Assert that there is Left Section")
    public DifferentElementSteps checkLeftSection() {
        //Step 10.
        boolean sidebarIsDisplayed = elementPage.navigationSidebar.isDisplayed();
        softAssert.assertThat(sidebarIsDisplayed).as("Left section is not found").isTrue();
        return this;
    }

    @Step
    @Description(value = "Select checkboxes")
    public DifferentElementSteps selectCheckboxes(String... values) {
        //Step 11.
        for (String value : values) {
            elementPage.findInputOfCheckboxByLabel(value).click();
        }
        return this;
    }

    @Step
    @Description(value = "Assert that for each checkbox there is an individual log row and value"
            + "is corresponded to the status of checkbox.")
    public DifferentElementSteps checkCheckboxes(Boolean state,String... values) {
        //Step 12.
        Set<String> expectedLogMessages = new HashSet<>();
        for (String value : values) {
            expectedLogMessages.add(
                    value  + ": condition changed to " + state.toString());
        }
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
        return this;
    }

    @Step
    @Description(value = "Select radio")
    public DifferentElementSteps selectRadio(String... values) {
        //Step 13.
        for (String value : values) {
            elementPage.findInputOfRadioByLabel(value).click();
        }
        return this;
    }

    @Step
    @Description(value = "Assert that for radiobutton there is a log row"
            + " and value is corresponded to the status of radiobutton.")
    public DifferentElementSteps checkRadios(String... values) {
        //Step 14.
        Set<String> expectedLogMessages = new HashSet<>();
        for (String value : values) {
            expectedLogMessages.add(
                    "metal: value changed to " + value);
        }
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
        return this;
    }

    @Step
    @Description(value = "Select in dropdown")
    public DifferentElementSteps selectDropdown(String... values) {
        //Step 15.
        for (String value : values) {
            elementPage.getOptionByName(value).click();
        }
        return this;
    }

    @Step
    @Description(value = "Assert that for dropdown there is a log row"
            + "and value is corresponded to the selected value.")
    public DifferentElementSteps checkDropdown(String... values) {
        //Step 16.
        Set<String> expectedLogMessages = new HashSet<>();
        for (String value : values) {
            expectedLogMessages.add("Colors: value changed to " + value);
        }
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
        return this;
    }

    @Step
    public DifferentElementSteps checkSoftAssertions() {
        softAssert.assertAll();
        return this;
    }
}
