package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6.domain.MetalAndColor;
import hw6.domain.User;
import hw6.pages.HomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static hw6.JdiSite.metalsAndColorsPage;


public class MetalAndColorsPageTest {

    @BeforeSuite
    public void beforeClass() {
        PageFactory.initElements(JdiSite.class);
    }

    @BeforeClass
    public void loginUser() {
        JdiSite.open();
        JdiSite.login(User.Roman);
        HomePage.userLabel.is().text(User.Roman.getFullName());
    }

    @Test(dataProvider = "Metal and Color Provider",
            dataProviderClass = DataProviders.class)
    public void testMetalAndColor(MetalAndColor metalAndColor) throws Exception {
        JdiSite.metalsAndColorsPage.open();
        JdiSite.metalsAndColorsPage.isOpened();
        metalsAndColorsPage.submitForm(metalAndColor);
        metalsAndColorsPage.assertResult(metalAndColor);
    }

    @AfterSuite()
    public void afterClass() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
