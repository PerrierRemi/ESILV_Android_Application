package fr.esilv.cocktailapp;

import androidx.annotation.NonNull;

import java.util.List;

public class CategorySearchResponseCocktails {
    private List<CategorySearchResultCocktails> drinks;

    @NonNull
    List<CategorySearchResultCocktails> getDrinks() {
        return drinks;
    }
}
