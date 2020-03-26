package fr.esilv.cocktailapp.holder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.esilv.cocktailapp.R;
import fr.esilv.cocktailapp.activity_category.CategoryActivity;
import fr.esilv.cocktailapp.api.Category;

public class CategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    String nameCategory;

    private TextView nameCategoryView;

    public CategoryHolder(@NonNull View itemView) {
        super(itemView);
        this.nameCategoryView = itemView.findViewById(R.id.CategoryName);
        itemView.setOnClickListener(this);

    }

    public void bind(final Category categorySearchResult) {
        nameCategory = categorySearchResult.getCategory();
        nameCategoryView.setText(nameCategory);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), CategoryActivity.class);
        intent.putExtra("NAME_CATEGORY", nameCategory);
        v.getContext().startActivity(intent);
    }
}
