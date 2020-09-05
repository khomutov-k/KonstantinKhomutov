package hw6.domain.enums;

import com.google.gson.annotations.SerializedName;

public enum Color {
    @SerializedName("Red")
    RED("Red"),
    @SerializedName("Green")
    GREEN("Green"),
    @SerializedName("Blue")
    BLUE("Blue"),
    @SerializedName("Yellow")
    YELLOW("Yellow");

    private final String text;
    Color(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
