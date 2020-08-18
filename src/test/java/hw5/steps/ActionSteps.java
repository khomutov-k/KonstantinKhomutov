package hw5.steps;

import hw5.driver.DriverSingleton;
import hw5.page.DifferentElementPage;
import hw5.page.HomePage;
import hw5.page.UserTablePage;
import io.cucumber.java.en.When;

public class ActionSteps {

    DifferentElementPage elementPage = new DifferentElementPage(DriverSingleton.getDriver());
    HomePage homePage = new HomePage(DriverSingleton.getDriver());
    UserTablePage userTablePage = new UserTablePage(DriverSingleton.getDriver());

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

    @When("I click on {string} button in Service dropdown")
    public void clickOnUserTableButtonInServiceDropdown(String buttonName) {
        homePage.findLinkByNameInServiceDropdown(buttonName).click();
    }

    @When("I click on {string} button in Header")
    public void clickOnServiceButtonInHeader(String buttonName) {
        homePage.findLinkByNameInHeader(buttonName).click();
    }

    @When("I select vip checkbox for {string}")
    public void selectVipCheckbox(String username) {
        userTablePage.getCheckboxByUsername(username).click();
    }
}
