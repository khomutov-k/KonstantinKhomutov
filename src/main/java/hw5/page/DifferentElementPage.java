package hw5.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementPage extends BasePage {

    @FindBy(css = "input[type=\"checkbox\"]")
    public List<WebElement> checkBoxes;
    @FindBy(className = "label-checkbox")
    public List<WebElement> checkBoxesLabels;
    @FindBy(css = "input[type=\"radio\"]")
    public List<WebElement> radios;
    @FindBy(className = "label-radio")
    public List<WebElement> radioLabels;
    @FindBy(tagName = "select")
    public WebElement dropdown;
    @FindBy(css = ".main-content .uui-button")
    public List<WebElement> buttons;
    @FindBy(name = "log-sidebar")
    public WebElement logSidebar;
    @FindBy(name = "navigation-sidebar")
    public WebElement navigationSidebar;


    public DifferentElementPage(WebDriver driver) {
        super(driver);
    }

    public WebElement findInputOfCheckboxByLabel(String label) {
        return findInputOfElementByLabel(label, checkBoxesLabels);
    }

    public WebElement findInputOfRadioByLabel(String label) {
        return findInputOfElementByLabel(label, radioLabels);
    }

    private WebElement findInputOfElementByLabel(String label, List<WebElement> elements) {
        for (WebElement span : elements) {
            if (span.getText().equals(label)) {
                return span.findElement(By.tagName("input"));
            }
        }
        return null;
    }

    public List<WebElement> getLogsLine() {
        return logSidebar.findElements(By.tagName("li"));
    }

    public WebElement getOptionByName(String name) {
        List<WebElement> options = dropdown.findElements(By.tagName("Option"));
        for (WebElement option : options) {
            if (name.equals(option.getText())) {
                return option;
            }
        }
        return null;
    }
}
