package hw6.forms;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw6.domain.MetalAndColor;

@FindBy(className = "form")
public class MetalAndColorForm extends Form<MetalAndColor> {

    @FindBy(id = "submit-button")
    public static Button submitBtn;

    @FindBy(css = "[type=radio]")
    public static RadioButtons summary;
    @Css("#elements-checklist [type=checkbox]")
    public static Checklist elements;

    @JDropdown(root = "#vegetables",
            value = "#salad-dropdown > button",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetables;

    @JDropdown(root = "div[ui=dropdown]",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;
}
