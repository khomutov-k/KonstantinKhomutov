//package hw2.ex1;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class Exercise1 {
//
//    private WebDriver driver;
//    private String baseUrl;
//
//    @BeforeTest
//    public void setUp()  {
//        driver = new ChromeDriver();
//        // Step 1 Goto https://jdi-testing.github.io/jdi-light/index.html
//        baseUrl = "https://jdi-testing.github.io/jdi-light/index.html  ";
//    }
//    @Test
//    public void exercise1TestCase()  {
//
//        driver.get(baseUrl);
//        new WebDriverWait(driver, 20)
//                .until(ExpectedConditions.presenceOfElementLocated(By.className("main-content")));
//        //Step 2. Verify Title of the page
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Home Page";
//        Assert.assertEquals(actualTitle,expectedTitle);
//        WebElement toggle = driver.findElement(By.cssSelector("a.dropdown-toggle"));
//        toggle.click();
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("login-form")));
//        LoginForm form = new LoginForm(driver);
//        form.logIn();
//        driver.quit();
//    }
//}
