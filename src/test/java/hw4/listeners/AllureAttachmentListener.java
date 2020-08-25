package hw4.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class AllureAttachmentListener extends TestListenerAdapter {

    @Attachment(value = "Fail attachment", type = "image/png")
    public byte[] makeScreenShot(ITestContext context) {
        byte[] array = {1};
        WebDriver driver = (WebDriver) context.getAttribute("driver");
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException ex) {
            ex.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        makeScreenShot(tr.getTestContext());
    }

}
