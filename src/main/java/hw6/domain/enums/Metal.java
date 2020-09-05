package hw6.domain.enums;

import com.google.gson.annotations.SerializedName;

public enum Metal {
    @SerializedName("Gold")
    GOLD("Gold"),
    @SerializedName("Silver")
    EARTH("Silver"),
    @SerializedName("Bronze")
    BRONZE("Bronze"),
    @SerializedName("Selen")
    SELEN("Selen");

    private final String text;
    Metal(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
