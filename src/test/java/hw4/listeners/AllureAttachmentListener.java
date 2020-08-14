package hw4.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static hw4.driver.DriverSingleton.getDriver;


public class AllureAttachmentListener extends TestListenerAdapter {

    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenShot() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException ex) {
            ex.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        makeScreenShot();
    }

}
