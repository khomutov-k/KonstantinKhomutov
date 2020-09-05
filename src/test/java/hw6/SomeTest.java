package hw6;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hw6.domain.MetalAndColor;
import hw6.domain.User;
import hw6.pages.HomePage;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import static hw6.JdiSite.metalsAndColorsPage;


public class SomeTest {

    @BeforeSuite
    public void beforeClass() {
        PageFactory.initElements(JdiSite.class);
    }

    @BeforeClass
    public void testLogin() {
        JdiSite.open();
        JdiSite.login(User.Roman);
        HomePage.userLabel.is().text(User.Roman.getFullName());
    }

    @Test(dataProvider = "MetalAndColorProvider")
    public void testMetalAndColor(MetalAndColor metalAndColor) {
        JdiSite.metalsAndColorsPage.open();
        JdiSite.metalsAndColorsPage.isOpened();
//        metalsAndColorsPage.form.submit(metalAndColor);
        metalsAndColorsPage.submitForm(metalAndColor);
        metalsAndColorsPage.assertResult(metalAndColor);
    }

    @DataProvider(name = "MetalAndColorProvider")
    public Iterator<Object> testName() {
        Gson gson = new Gson();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Object> dataList = gson.fromJson(fileReader, new TypeToken<List<MetalAndColor>>() {
        }.getType());
        return dataList.iterator();
    }

//    @AfterClass
//    public void logout() {
//        JdiSite.logout();
//    }

    @AfterSuite()
    public void afterClass() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
