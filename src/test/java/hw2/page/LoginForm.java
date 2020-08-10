package hw2.page;

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
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String username, String password) {

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("login-form")));
        toggle.click();
        nameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmBtn.click();
    }
}

