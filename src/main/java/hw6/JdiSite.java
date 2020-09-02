package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;

@JSite("https://jdi-docs.github.io/jdi-light/#highlights")
public class JdiSite {

    public static HomePage homepage;

    public static void open() {
        homepage.open();
    }
}
