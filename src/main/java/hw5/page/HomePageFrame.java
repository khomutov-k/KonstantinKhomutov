package hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageFrame extends BasePage {

    WebDriver driver;

    @FindBy(id = "epam-logo")
    public WebElement logo;

    public HomePageFrame(WebDriver driver) {
        super(driver);
    }

    public void switchBack() {
        driver.switchTo().parentFrame();
    }
}
