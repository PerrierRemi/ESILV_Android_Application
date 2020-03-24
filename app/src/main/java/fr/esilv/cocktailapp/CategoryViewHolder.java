package fr.esilv.cocktailapp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    String nameCategory;

    private TextView nameCategoryView;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameCategoryView = itemView.findViewById(R.id.CategoryName);
        itemView.setOnClickListener(this);

    }

    public void bind(final CategorySearchResult categorySearchResult) {
        nameCategory = categorySearchResult.getStrCategory();
        nameCategoryView.setText(nameCategory);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), CategoryCocktailsActivity.class);
        intent.putExtra("NAME_CATEGORY", nameCategory);
        v.getContext().startActivity(intent);
    }
}
