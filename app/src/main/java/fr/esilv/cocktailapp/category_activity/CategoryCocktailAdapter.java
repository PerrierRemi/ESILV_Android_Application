package fr.esilv.cocktailapp.category_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.CategorySearchResult;

public class CategoryCocktailAdapter extends RecyclerView.Adapter<CategoryCocktailHolder> {
    private final List<CategorySearchResult> categories;

    public CategoryCocktailAdapter(List<CategorySearchResult> categories) {
        this.categories = categories;
    }


    @NonNull
    @Override
    public CategoryCocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_category_view, parent, false);
        return new CategoryCocktailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryCocktailHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories != null ? categories.size() : 0;
    }
}
