package hw6.domain;

import com.epam.jdi.tools.DataClass;
import com.google.gson.annotations.SerializedName;
import hw6.domain.enums.Color;
import hw6.domain.enums.Element;
import hw6.domain.enums.Metal;
import hw6.domain.enums.Vegetable;

import java.util.List;

public class MetalAndColor extends DataClass<MetalAndColor> {
    List<Integer> summary;
    List<Element> elements;
    @SerializedName("color")
    Color colors;
    Metal metals;
    List<Vegetable> vegetables;

    public List<Integer> getSummary() {
        return summary;
    }

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public Color getColors() {
        return colors;
    }

    public void setColors(Color colors) {
        this.colors = colors;
    }

    public Metal getMetals() {
        return metals;
    }

    public void setMetals(Metal metals) {
        this.metals = metals;
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<Vegetable> vegetables) {
        this.vegetables = vegetables;
    }
}
