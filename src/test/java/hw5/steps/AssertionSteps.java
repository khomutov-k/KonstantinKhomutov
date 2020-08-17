package hw5.steps;

import hw5.driver.DriverSingleton;
import hw5.page.DifferentElementPage;
import hw5.utils.Helper;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

import java.util.HashSet;
import java.util.Set;


public class AssertionSteps {

    DifferentElementPage elementPage = new DifferentElementPage(DriverSingleton.getDriver());

    @Then("I should see {string}: condition changed to {string} "
            + "in logs bar on the Different Element Page")
    public void shouldSeeConditionChangedInLogsBarOnTheDifferentElementPage(String label, String state) {
        SoftAssertions softAssert = new SoftAssertions();
        Set<String> expectedLogMessage = new HashSet<>();
        expectedLogMessage.add(
                    label  + ": condition changed to " + state);
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
}
