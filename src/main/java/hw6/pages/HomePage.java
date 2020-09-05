package hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw6.domain.User;
import hw6.forms.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {

    public static LoginForm loginForm;

    @FindBy(id = "user-icon")
    public static Icon userIcon;
    @FindBy(id = "user-name")
    public static Label userLabel;


    public static void login(User user) {
        userIcon.click();
        if (userLabel.isDisplayed()) {
            loginForm.logout();
        }
        loginForm.login(user);
        userIcon.click();
    }
}
