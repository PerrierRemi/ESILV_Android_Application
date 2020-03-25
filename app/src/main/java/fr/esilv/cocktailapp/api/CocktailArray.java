package fr.esilv.cocktailapp.api;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class CocktailArray {
    @SerializedName("drinks")
    private List<Cocktail> cocktails;

    @NonNull
    public List<Cocktail> getCocktails() {
        return cocktails;
    }
}
