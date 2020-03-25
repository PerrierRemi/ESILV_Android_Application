package fr.esilv.cocktailapp.activity_category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Cocktail;

public class CocktailAdapter extends RecyclerView.Adapter<CocktailHolder> {
    private final List<Cocktail> drinks;

    public CocktailAdapter(List<Cocktail> drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_cocktail_view, parent, false);
        return new CocktailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailHolder holder, int position) {
        holder.bind(drinks.get(position));
    }

    @Override
    public int getItemCount() {
        return drinks != null ? drinks.size() : 0;

    }
}
