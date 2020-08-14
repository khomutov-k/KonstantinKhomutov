package hw4.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private String baseUrl = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(id = "second_frame")
    public WebElement secondFrame;
    @FindBy(name = "main-title")
    public WebElement mainTitle;
    @FindBy(name = "jdi-text")
    public WebElement mainText;
    @FindBy(css = ".nav > li")
    public List<WebElement> headerItems;
    @FindBy(className = "icons-benefit")
    public List<WebElement> benefitIcons;
    @FindBy(className = "benefit-txt")
    public List<WebElement> benefitTexts;
    @FindBy(css = "h3 a")
    public WebElement subHeaderLink;
    @FindBy(name = "navigation-sidebar")
    public WebElement navigationSidebar;
    @FindBy(tagName = "footer")
    public WebElement footer;
    @FindBy(css = "ul.nav li.dropdown li:nth-child(8)")
    public WebElement differentElementLink;



    @FindBy(id = "user-name")
    private WebElement username;
    private DifferentElementPage elementPage;
    private WebDriver driver;

    public DifferentElementPage getElementPage() {
        return elementPage;
    }

    public void openPage() {
        driver.get(baseUrl);
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        elementPage = new DifferentElementPage(driver);
        this.driver = driver;
    }

    public String getUserName() {
        return username.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitForPageLoad() {

        new WebDriverWait(this.driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("main-content")));
    }

    public HomePageFrame switchToFrame(String frameName) {
        driver.switchTo().frame(frameName);
        return new HomePageFrame(driver);
    }

    public LoginForm getLoginForm() {
        return new LoginForm(driver);
    }

    public List<WebElement> getHeaderServiceLinks() {
        driver.findElement(By.cssSelector("li[index=\"3\"] a")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.sub")));
        return driver.findElements(By.cssSelector("li[index=\"3\"] > ul li"));
    }

    public List<WebElement> getLeftSectionServiceLinks() {
        driver.findElement(By.cssSelector("ul.nav li.dropdown")).click();
        return driver.findElements(By.cssSelector("ul.nav li.dropdown li"));
    }

    public void close() {
        driver.close();
    }

}
