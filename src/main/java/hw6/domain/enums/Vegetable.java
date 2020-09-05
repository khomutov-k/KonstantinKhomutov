package hw6.domain.enums;

import com.google.gson.annotations.SerializedName;

public enum Vegetable {
    @SerializedName("Cucumber")
    CUCUMBER("Cucumber"),
    @SerializedName("Tomato")
    TOMATO("Tomato"),
    @SerializedName("Vegetables")
    VEGETABLE("Vegetables"),
    @SerializedName("Onion")
    ONION("Onion");

    private final String text;
    Vegetable(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
