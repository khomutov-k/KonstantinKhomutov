package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import hw6.domain.User;
import hw6.forms.LoginForm;
import hw6.pages.HomePage;
import hw6.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    public static LoginForm loginForm;
    public static HomePage homepage;
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        homepage.open();
    }

    public static void login(User user) {
        HomePage.login(user);
    }

    public static void logout() {
        loginForm.logout();
    }
}
