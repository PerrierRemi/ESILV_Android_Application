package fr.esilv.cocktailapp.api;

import androidx.annotation.NonNull;

import java.util.List;

public class CategorySearchResponse {
    private List<CategorySearchResult> drinks;

    @NonNull
    public List<CategorySearchResult> getDrinks() {
        return drinks;
    }

}
