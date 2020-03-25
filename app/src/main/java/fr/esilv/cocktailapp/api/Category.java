package fr.esilv.cocktailapp.api;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("strCategory")
    private String category;

    public String getCategory() {
        return category;
    }
}
