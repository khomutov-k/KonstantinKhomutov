package hw5.page;

import hw5.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginForm {

    WebDriver driver;

    @FindBy(css = ".uui-profile-menu a")
    WebElement toggle;
    @FindBy(css = "#login-form #name")
    WebElement nameInput;
    @FindBy(css = "#login-form #password")
    WebElement passwordInput;
    @FindBy(css = "#login-form #login-button")
    WebElement confirmBtn;


    public LoginForm(WebDriver driver) {
        PageFactory.initElements(driver,this);

        this.driver = driver;

    }

    public void login(User user) {
        final String username = user.getUserName();
        final String password = user.getPassword();
        toggle.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("login-form")));
        nameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmBtn.click();
    }
}

