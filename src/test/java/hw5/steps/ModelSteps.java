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

    @Given("I login as user Roman Iovlev")
    public void login() {

        User defaultUser = UserManager.getDefaultUserFromProperties();
        homePage.getLoginForm().login(defaultUser);
        if (!homePage.getUserName().equalsIgnoreCase("Roman Iovlev")) {
            throw new RuntimeException("Wrong user was authorized");
        }
    }

    @Given("I open Different Element Page")
    public void openDifferentElementPage() {
        homePage.openDifferentElementPage();
    }
}
