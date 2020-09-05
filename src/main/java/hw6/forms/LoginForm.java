package hw6.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw6.domain.User;

@Css("#login-form")
public class LoginForm extends Form<User> {

    @Css("#name")
    TextField username;
    @Css("#password")
    TextField password;
    @Css("#login-button")
    Button loginButton;
    @Css(".btn-login")
    Button logout;

    public void logout() {
        logout.click();
    }
}
