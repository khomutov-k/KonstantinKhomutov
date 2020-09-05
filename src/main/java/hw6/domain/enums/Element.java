package hw6.domain.enums;

import com.google.gson.annotations.SerializedName;

public enum Element {
    @SerializedName("Water")
    WATER("Water"),
    @SerializedName("Earth")
    EARTH("Earth"),
    @SerializedName("Wind")
    WIND("Wind"),
    @SerializedName("Fire")
    FIRE("Fire");

    private final String text;

    Element(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
