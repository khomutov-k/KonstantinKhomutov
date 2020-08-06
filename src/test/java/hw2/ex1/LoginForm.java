package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {

    WebDriver webDriver;
    private By usernameBy = By.cssSelector("#login-form #name");
    private By passwordBy = By.cssSelector("#login-form #password");
    private By enterBy = By.cssSelector("#login-form #login-button");


    public LoginForm(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void logIn(String username, String password) {

        WebElement nameInput = webDriver.findElement(usernameBy);
        nameInput.sendKeys(username);
        WebElement passwordInput = webDriver.findElement(passwordBy);
        passwordInput.sendKeys(password);
        WebElement confirmBtn = webDriver.findElement(enterBy);
        confirmBtn.click();
    }
}
