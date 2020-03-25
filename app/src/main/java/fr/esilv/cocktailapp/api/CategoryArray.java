package fr.esilv.cocktailapp.api;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryArray {
    @SerializedName("drinks")
    private List<Category> categories;

    @NonNull
    public List<Category> getCategories() {
        return categories;
    }

}
