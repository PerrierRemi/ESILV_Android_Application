package fr.esilv.cocktailapp.api;

import androidx.annotation.NonNull;

import java.util.List;

public class CocktailList {
    private List<Cocktail> drinks;

    @NonNull
    public List<Cocktail> getDrinks() {
        return drinks;
    }
}
