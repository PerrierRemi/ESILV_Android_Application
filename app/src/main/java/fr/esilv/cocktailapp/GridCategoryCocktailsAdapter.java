package fr.esilv.cocktailapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GridCategoryCocktailsAdapter extends RecyclerView.Adapter<GridCategoryCocktailsHolder> {
    private final List<CategorySearchResultCocktails> drinks;

    public GridCategoryCocktailsAdapter(List<CategorySearchResultCocktails> drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public GridCategoryCocktailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_cocktail_view, parent, false);
        return new GridCategoryCocktailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridCategoryCocktailsHolder holder, int position) {
        holder.bind(drinks.get(position));
    }

    @Override
    public int getItemCount() {
        return drinks != null ? drinks.size() : 0;

    }
}
