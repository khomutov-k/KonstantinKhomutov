package hw5.steps;

import hw5.driver.DriverSingleton;
import hw5.model.User;
import hw5.model.UserManager;
import hw5.page.HomePage;
import io.cucumber.java.en.Given;

public class ModelSteps {

    HomePage homePage = new HomePage(DriverSingleton.getDriver());

    @Given("I open JDI main page")
    public void openJDIMainPage() {
        homePage.openPage();
    }

    @Given("I login")
    public void login() {

        User defaultUser = UserManager.getDefaultUserFromProperties();
        homePage.getLoginForm().login(defaultUser);

    }

    @Given("I open Different Element Page")
    public void openDifferentElementPage() {
        homePage.openDifferentElementPage();
    }
}
