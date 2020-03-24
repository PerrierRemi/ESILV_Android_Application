package fr.esilv.cocktailapp.home_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.api.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder> {
    private final List<Category> categories;

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }


    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_category_view, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        holder.bind(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories != null ? categories.size() : 0;
    }
}
