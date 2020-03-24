package fr.esilv.cocktailapp.home_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.CategorySearchResultCocktails;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryHolder> {
    private final List<CategorySearchResultCocktails> drinks;

    public HomeCategoryAdapter(List<CategorySearchResultCocktails> drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public HomeCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_cocktail_view, parent, false);
        return new HomeCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCategoryHolder holder, int position) {
        holder.bind(drinks.get(position));
    }

    @Override
    public int getItemCount() {
        return drinks != null ? drinks.size() : 0;

    }
}
