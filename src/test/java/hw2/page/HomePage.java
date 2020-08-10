package hw2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    private By usernameBy = By.cssSelector("span#user-name");
    private By navbarItemsBy = By.cssSelector(".nav > li");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("main-content")));
    }

    public String getUserName() {
        return driver.findElement(usernameBy).getText();
    }

}
