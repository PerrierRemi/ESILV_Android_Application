package fr.esilv.cocktailapp.api;

import androidx.annotation.NonNull;

import java.util.List;

public class CategorySearchResponseCocktails {
    private List<CategorySearchResultCocktails> drinks;

    @NonNull
    public List<CategorySearchResultCocktails> getDrinks() {
        return drinks;
    }
}
