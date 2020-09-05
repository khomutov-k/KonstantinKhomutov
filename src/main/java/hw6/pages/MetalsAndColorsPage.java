package hw6.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw6.domain.MetalAndColor;
import hw6.domain.enums.Element;
import hw6.domain.enums.Vegetable;
import hw6.forms.MetalAndColorForm;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@Url("metals-colors.html")
public class MetalsAndColorsPage extends WebPage {
    @FindBy(css = ".results li")
    public WebList resultStrings;
    public MetalAndColorForm form;
    public MetalAndColorForm getForm() {
        return form;
    }

    public void submitForm(MetalAndColor metalAndColor) {
        for (Integer number : metalAndColor.getSummary()) {
            MetalAndColorForm.summary.select(String.valueOf(number));
        }
        for (Element element : metalAndColor.getElements()) {
            MetalAndColorForm.elements.select(element);
        }
        MetalAndColorForm.metals.select(metalAndColor.getMetals());
        MetalAndColorForm.colors.select(metalAndColor.getColors());
        // Reset default dropdown value
        MetalAndColorForm.vegetables.select(Vegetable.VEGETABLE);
        for (Vegetable vegetable : metalAndColor.getVegetables()) {
            MetalAndColorForm.vegetables.select(vegetable);
        }
        MetalAndColorForm.submitBtn.click();
    }

   public void assertResult(MetalAndColor metalAndColor) {
       for (UIElement resultString : resultStrings) {
           String text = resultString.getText();
           String[] result = text.split(":",2);

           String key = result[0].trim();
           String value = result[1].trim();
           switch (key){
               case ("Summary") : {
                   int sum = metalAndColor.getSummary().stream()
                           .mapToInt(Integer::intValue).sum();
                   assertThat(value).isEqualTo(String.valueOf(sum));
                   break;
               }
               case ("Elements") : {
                   assertEnumListContainsExpectedValue(metalAndColor.getElements(), value);
                   break;
               }
               case ("Color") : {
                   String expectedColor = metalAndColor.getColors().toString();
                    assertThat(value).isEqualTo(expectedColor);
                    break;
               }
               case ("Metal") : {
                   String expectedMetal = metalAndColor.getMetals().toString();
                   assertThat(value).isEqualTo(expectedMetal);
                   break;
               }
               case ("Vegetables") : {
                   assertEnumListContainsExpectedValue(metalAndColor.getVegetables(), value);
                   break;
               }
           }
       }
   }

    private void assertEnumListContainsExpectedValue(List<?> enumList, String value) {
        Set<String> expectedValues = enumList.stream()
                .map(s -> s.toString().trim())
                .collect(Collectors.toSet());
        String[] elementsFromResult = Arrays.stream(value.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        assertThat(elementsFromResult).containsExactlyInAnyOrderElementsOf(expectedValues);
    }
}
