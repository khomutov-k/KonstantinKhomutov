package hw5.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserTablePage extends BasePage {

    @FindBy(css = "#user-table tr")
    private List<WebElement> tableRows;
    @FindBy(name = "log-sidebar")
    public WebElement logSidebar;

    private By selectBy = By.tagName("select");
    private By usernameBy = By.tagName("a");
    private By descriptionBy = By.cssSelector(".user-descr span");
    private By checkboxBy = By.cssSelector("input");

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLogLines() {
        return logSidebar.findElements(By.tagName("li"));
    }

    public WebElement getDropdownInSpecifiedRow(String number) {
        WebElement row = findRowInTableByNumber(number);
        return row.findElement(selectBy);
    }

    public WebElement getUsernameInSpecifiedRow(String number) {
        WebElement row = findRowInTableByNumber(number);
        return row.findElement(usernameBy);
    }

    public WebElement getDescriptionInSpecifiedRow(String number) {
        WebElement row = findRowInTableByNumber(number);
        return row.findElement(descriptionBy);
    }

    public WebElement getCheckboxInSpecifiedRow(String number) {
        WebElement row = findRowInTableByNumber(number);
        return row.findElement(checkboxBy);
    }

    public WebElement getCheckboxByUsername(String username) {
        WebElement row = findRowInTableByUser(username);
        return row.findElement(checkboxBy);
    }

    public WebElement getOptionByNameWithSpecifiedUser(String optionName, String userName) {
        WebElement row = findRowInTableByUser(userName);
        row.findElement(By.tagName("select")).click();
        List<WebElement> options = row.findElements(By.cssSelector("select option"));
        for (WebElement option : options) {
            String actualText = option.getText();
            if (actualText.equalsIgnoreCase(optionName)) {
                return option;
            }
        }
        return row.findElement(checkboxBy);
    }

    private WebElement findRowInTableByNumber(String number) {
        return findRowInTableBy(number, "td:first-child");
    }

    private WebElement findRowInTableByUser(String userName) {
        return findRowInTableBy(userName, "a");
    }

    private WebElement findRowInTableBy(String field, String selector) {
        for (int i = 1; i < tableRows.size(); i++) {
            WebElement row = tableRows.get(i);
            final WebElement rowNumber = row.findElement(By.cssSelector(selector));
            if (rowNumber.getText().equals(field)) {
                return row;
            }
        }
        throw new RuntimeException("Table row wasn't found");
    }
}
