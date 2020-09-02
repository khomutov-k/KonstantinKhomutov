package hw6;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.ui.html.elements.common.Text;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @Name("jdi-text")
    public Text descriptionText;
}
