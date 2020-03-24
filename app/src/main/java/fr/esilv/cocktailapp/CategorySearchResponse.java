package fr.esilv.cocktailapp;

import androidx.annotation.NonNull;

import java.util.List;

public class CategorySearchResponse {
    private List<CategorySearchResult> drinks;

    @NonNull
    List<CategorySearchResult> getDrinks() {
        return drinks;
    }

}
