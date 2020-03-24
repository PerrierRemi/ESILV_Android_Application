package fr.esilv.cocktailapp;

import androidx.annotation.NonNull;

import java.util.List;

public class CocktailSearchResponse {
    private List<CocktailSearchResult> drinks;

    @NonNull
    List<CocktailSearchResult> getDrinks() {
        return drinks;
    }
}
