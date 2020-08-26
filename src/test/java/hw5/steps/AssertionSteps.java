package hw5.steps;

import hw5.driver.DriverSingleton;
import hw5.page.DifferentElementPage;
import hw5.page.UserTablePage;
import hw5.utils.Helper;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertionSteps {

    DifferentElementPage elementPage = new DifferentElementPage(DriverSingleton.getDriver());
    UserTablePage userTablePage = new UserTablePage(DriverSingleton.getDriver());

    @Then("I should see {string}: condition changed to {string} "
            + "in logs bar on the Different Element Page")
    public void shouldSeeConditionChangedInLogsBarOnTheDifferentElementPage(String label, String state) {
        SoftAssertions softAssert = new SoftAssertions();
        Set<String> expectedLogMessage = new HashSet<>();
        expectedLogMessage.add(
                label + ": condition changed to " + state);
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessage, softAssert);
        softAssert.assertAll();
    }


    @Then("I should see metal: value changed to {string}"
            + " in logs bar on the Different Element Page")
    public void shouldSeeMetalValueChangedInLogsBarOnTheDifferentElementPage(String label) {
        SoftAssertions softAssert = new SoftAssertions();
        Set<String> expectedLogMessages = new HashSet<>();
        expectedLogMessages.add("metal: value changed to " + label);
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
    }


    @Then("I should see Colors: value changed to {string} "
            + "in logs bar on the Different Element Page")
    public void shouldSeeColorsValueChangedInLogsBarOnTheDifferentElementPage(String label) {
        SoftAssertions softAssert = new SoftAssertions();
        Set<String> expectedLogMessages = new HashSet<>();
        expectedLogMessages.add("Colors: value changed to " + label);
        Helper.textOfWebElementsContainsSetText(elementPage.getLogsLine(),
                expectedLogMessages, softAssert);
    }

    @Then("User Table page should be opened")
    public void userTablePageShouldBeOpened() {
        assertThat(userTablePage.getTitle()).as("Title is not correct")
                .isEqualTo("User Table");
    }

    @Then("Dropdown should be displayed in {string} row at Users Table")
    public void dropdownShouldBeDisplayedInNumberAtUsersTable(String rowNumber) {
        final boolean dropdownIsDisplayed = userTablePage.getDropdownInSpecifiedRow(rowNumber).isDisplayed();
        assertThat(dropdownIsDisplayed).as("Can not find dropdown in the row number:" + rowNumber)
                .isTrue();
    }

    @Then("Username should be displayed in {string} row as {string} at Users Table")
    public void usernameShouldBeDisplayedInRowNumberAsUsernameAtUsersTable(
            String rowNumber, String username) {
        String usernameFromTable = userTablePage.getUsernameInSpecifiedRow(rowNumber).getText();
        assertThat(usernameFromTable).as("Username doesn't match expected" + username)
                .isEqualTo(username);
    }

    @Then("Checkboxes should be displayed in {string} row at Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedAtUsersTableOnUserTablePage(String row) {
        boolean checkboxIsDisplayed = userTablePage.getCheckboxInSpecifiedRow(row).isDisplayed();
        assertThat(checkboxIsDisplayed).as("Description is not correspond ")
                .isTrue();
    }

    @Then("Log row has {string} text in log section")
    public void logRowHasTextInLogSection(String expectedLog) {
        SoftAssertions softAssertions = new SoftAssertions();
        Helper.textOfWebElementsContainsSetText(userTablePage.getLogLines(),
                new HashSet<>(Collections.singletonList(expectedLog)),
                softAssertions);
        softAssertions.assertAll();
    }

    @Then("Description text under image in {string} row should be displayed as {string} with {string}")
    public void descriptionTextUnderImageInNumberRowShouldBeDisplayedAsDescriptionWithAdditionalDescription(
            String row, String description, String addition) {
        String fullDescription;
        if (addition.isEmpty()) {
            fullDescription = description;
        } else {
            fullDescription = description + "\n" + addition;
        }
        String descriptionFromTable = userTablePage.getDescriptionInSpecifiedRow(row).getText();
        assertThat(descriptionFromTable).as("Description is not correspond ")
                .isEqualTo(fullDescription);

    }

    @Then("Dropdown should have next options for user {string} at Users Table")
    public void dropdownShouldHaveNextOptionsForUserRomanAtUsersTable(String username, List<String> options) {
        boolean optionIsFound = false;
        for (String optionName : options) {
            optionIsFound = userTablePage.getOptionByNameWithSpecifiedUser(optionName, username)
                    .isDisplayed();
            if (!optionIsFound) break;
        }
        assertThat(optionIsFound).as("Some of option wasn't found")
                .isTrue();
    }
}
