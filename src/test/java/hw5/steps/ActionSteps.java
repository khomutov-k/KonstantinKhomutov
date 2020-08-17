package hw5.steps;

import hw5.driver.DriverSingleton;
import hw5.page.DifferentElementPage;
import io.cucumber.java.en.When;

public class ActionSteps {

    DifferentElementPage elementPage = new DifferentElementPage(DriverSingleton.getDriver());

    @When("I click {string} checkbox on Different Element Page")
    public void clickCheckboxOnDifferentElementPage(String checkboxLabel) {
        elementPage.findInputOfCheckboxByLabel(checkboxLabel).click();
    }

    @When("I click {string} radio on Different Element Page")
    public void clickRadioOnDifferentElementPage(String radioLabel) {
        elementPage.findInputOfRadioByLabel(radioLabel).click();
}


    @When("I click {string} option in dropdown on Different Element Page")
    public void iClickYellowOptionInDropdownOnDifferentElementPage(String optionName) {
        elementPage.getOptionByName(optionName).click();
    }
}
