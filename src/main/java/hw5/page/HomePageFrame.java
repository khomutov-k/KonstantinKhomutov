package hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFrame {

    WebDriver driver;

    @FindBy(id = "epam-logo")
    public WebElement logo;

    public HomePageFrame(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void switchBack() {
        driver.switchTo().parentFrame();
    }
}
