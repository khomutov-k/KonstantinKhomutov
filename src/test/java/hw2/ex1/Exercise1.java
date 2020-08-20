package hw2.ex1;

import hw2.TestCommons;
import hw2.page.LoginForm;
import hw2.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise1 extends TestCommons {

    @Test
    public void exercise1TestCase() {

        // Step 1. Open test site by URL
        driver.get(baseUrl);

        //Step 2. Verify Title of the hw2.page
        String actualTitle = driver.getTitle();
        String expectedTitle = "Home Page";
        assertEquals(actualTitle, expectedTitle);

        //Step 3. Perform login
        LoginForm form = new LoginForm(driver);
        form.login("Roman", "Jdi1234");

        //Step 4.Assert User name in the left-top side of screen that user is loggined
        String actualUsername = driver.findElement(By.cssSelector("span#user-name")).getText();
        String expectedUsername = "ROMAN IOVLEV";
        assertEquals(actualUsername, expectedUsername);

        //Step 5. Verify Title of the hw2.page
        actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle);

        //Step 6. Assert that there are 4 items on the header section are displayed
        // and they have proper texts
        List<WebElement> headerItems = driver.findElements(By
                .cssSelector(".nav > li"));
        Set<String> headerTitles = new HashSet<>(Arrays.asList(
                "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"));
        Helper.compareWebElementsWithSet(headerItems, headerTitles);

        //Step 7. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        List<WebElement> benefitIcons = driver.findElements(By
                .className("icons-benefit"));
        int actualNumberOfIcons = benefitIcons.size();
        int expectedNumberOfIcons = 4;
        assertEquals(actualNumberOfIcons, expectedNumberOfIcons);

        //Step 8. Assert that there are 4 texts on the Index Page under icons
        // and they have proper text
        List<WebElement> benefitTexts = driver.findElements(By.className("benefit-txt"));
        Set<String> benefitTextSet = new HashSet<>(Arrays.asList("To include good practices\n"
                        + "and ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),"
                        + "\nwish to get more…"));
        Helper.compareWebElementsWithSet(benefitTexts, benefitTextSet);

        //Step 9. Assert a text of the main headers
        String actualMainTitle = driver.findElement(By.name("main-title")).getText();
        String expectedMainTitle = "EPAM FRAMEWORK WISHES…";
        assertEquals(actualMainTitle, expectedMainTitle);

        String actualMainText = driver.findElement(By.name("jdi-text")).getText();
        String expectedMainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT,"
                + " SED DO EIUSMOD TEMPOR"
                + " INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM,"
                + " QUIS NOSTRUD EXERCITATION"
                + " ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE"
                + " DOLOR IN REPREHENDERIT IN"
                + " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
        assertEquals(actualMainText, expectedMainText);

        //Step 10. Assert that there is the iframe in the center of hw2.page
        assertTrue(driver.findElement(By.id("second_frame")).isDisplayed());

        //Step 11. Switch to the iframe
        // and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("second_frame");
        assertTrue(driver.findElement(By.id("epam-logo")).isDisplayed());

        //Step 12. Switch to original window back
        driver.switchTo().parentFrame();

        //Step 13. Assert a text of the sub header
        WebElement subHeaderLink = driver.findElement(By.cssSelector("h3 a"));
        String actualSubHeaderText = subHeaderLink.getText();
        String expectedSubHeaderText = "JDI GITHUB";
        assertEquals(actualSubHeaderText, expectedSubHeaderText);

        //Step 14. Assert that JDI GITHUB is a link and has a proper URL
        String actualLink = subHeaderLink.getAttribute("href");

        //String expectedLink = "https://jdi-testing.github.io/jdi-light/index.html";
        String expectedLink = "https://github.com/epam/JDI";
        assertEquals(actualLink, expectedLink);

        //Step 15. Assert that there is Left Section
        assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());

        //Step 16. Assert that there is Footer
        assertTrue(driver.findElement(By.tagName("footer")).isDisplayed());

    }


}

