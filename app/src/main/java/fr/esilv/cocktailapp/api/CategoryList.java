package fr.esilv.cocktailapp.api;

import androidx.annotation.NonNull;

import java.util.List;

public class CategoryList {
    private List<Category> drinks;

    @NonNull
    public List<Category> getDrinks() {
        return drinks;
    }

}
